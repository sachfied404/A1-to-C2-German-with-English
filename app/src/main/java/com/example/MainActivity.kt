package com.example

import android.os.Bundle
import android.util.Log
import android.speech.tts.TextToSpeech
import java.util.Locale
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

// Data Models (Moved to VocabularyData.kt)
val levels = listOf("A1", "A2", "B1", "B2", "C1", "C2", "TOP1000", "VERBS", "LISTS")

class MainActivity : ComponentActivity(), TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    private var isTtsReady = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize Speech engine for interactive German pronunciation help
        tts = TextToSpeech(this, this)

        // Make system status and navigation bars fully transparent with light icons
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT)
        )

        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = BgPrimary
                ) { innerPadding ->
                    GermanMasteryDashboard(
                        onPlayAudio = ::speak,
                        modifier = Modifier
                            .padding(top = innerPadding.calculateTopPadding(), bottom = innerPadding.calculateBottomPadding())
                            .fillMaxSize()
                    )
                }
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale.GERMAN)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "German language is not supported or missing data")
            } else {
                isTtsReady = true
            }
        } else {
            Log.e("TTS", "Text-to-Speech initialization failed")
        }
    }

    private fun speak(text: String) {
        if (isTtsReady) {
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "GermanSpeech")
        } else {
            Log.e("TTS", "TTS Engine is not ready or failed to initialize")
        }
    }

    override fun onDestroy() {
        tts?.stop()
        tts?.shutdown()
        super.onDestroy()
    }
}

@Composable
fun GermanMasteryDashboard(
    onPlayAudio: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var activeLevel by remember { mutableStateOf("A1") }
    
    val filteredWords = remember(searchQuery, activeLevel) {
        allVocabularyData.filter {
            (it.level == activeLevel) && (
                it.german.contains(searchQuery, ignoreCase = true) ||
                it.english.contains(searchQuery, ignoreCase = true) ||
                it.pronunciation.contains(searchQuery, ignoreCase = true)
            )
        }
    }

    BoxWithConstraints(modifier = modifier, contentAlignment = Alignment.TopCenter) {
        val width = maxWidth
        val isMobileLess = width < 360.dp
        val isTabletOrWide = width >= 600.dp
        
        // Define adaptive paddings
        val horizontalPadding = if (isMobileLess) 12.dp else if (isTabletOrWide) 24.dp else 16.dp
        val listSpacing = if (isMobileLess) 10.dp else 14.dp
        
        Column(
            modifier = Modifier
                .widthIn(max = 1000.dp)
                .fillMaxSize()
                .padding(horizontal = horizontalPadding),
            verticalArrangement = Arrangement.spacedBy(listSpacing)
        ) {
            Spacer(modifier = Modifier.height(if (isMobileLess) 4.dp else 8.dp))
            HeaderRow(isMobileLess)
            LevelNavBar(activeLevel = activeLevel, isMobileLess = isMobileLess, onLevelSelect = { activeLevel = it })
            SearchBar(searchQuery) { searchQuery = it }
            StatsRow(nodes = filteredWords.size, mastered = 0)
            
            LazyVerticalGrid(
                columns = if (isTabletOrWide) GridCells.Adaptive(minSize = 340.dp) else GridCells.Fixed(1),
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.spacedBy(listSpacing),
                verticalArrangement = Arrangement.spacedBy(listSpacing),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(filteredWords) { word ->
                    VocabularyCardWrapper(word = word, isMobileLess = isMobileLess, onPlayAudio = onPlayAudio)
                }
                item(span = { GridItemSpan(maxLineSpan) }) {
                    FooterStatusBar()
                }
            }
        }
    }
}

@Composable
fun HeaderRow(isMobileLess: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "GERMAN MASTERY En-De",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = if (isMobileLess) 15.sp else 18.sp
                ),
                color = TextHigh
            )
            Text(
                text = "By Sach_IT",
                style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = if (isMobileLess) 9.sp else 11.sp
                ),
                color = AccentCyan
            )
        }
        Text(
            text = "OPS_CORE // A1",
            style = MaterialTheme.typography.labelMedium.copy(
                fontSize = if (isMobileLess) 10.sp else 12.sp
            ),
            color = AccentCyan
        )
    }
}

@Composable
fun LevelNavBar(activeLevel: String, isMobileLess: Boolean, onLevelSelect: (String) -> Unit) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(if (isMobileLess) 6.dp else 8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(levels) { level ->
            val isActive = level == activeLevel
            Surface(
                shape = CircleShape,
                color = if (isActive) AccentCyan.copy(alpha = 0.2f) else ButtonBg,
                border = if (isActive) BorderStroke(1.dp, AccentCyan) else null,
                modifier = Modifier.clickable { onLevelSelect(level) }
            ) {
                Text(
                    text = level,
                    modifier = Modifier.padding(
                        horizontal = if (isMobileLess) 12.dp else 16.dp,
                        vertical = if (isMobileLess) 6.dp else 8.dp
                    ),
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = if (isMobileLess) 12.sp else 14.sp
                    ),
                    color = if (isActive) TextHigh else TextMed
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(query: String, onQueryChange: (String) -> Unit) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        placeholder = { Text("Search words...", color = TextMed) },
        leadingIcon = { 
            Icon(Icons.Default.Search, contentDescription = "Search", tint = TextMed) 
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = AccentCyan,
            unfocusedBorderColor = BorderColor,
            focusedContainerColor = BgCard,
            unfocusedContainerColor = BgCard,
            focusedTextColor = TextHigh,
            unfocusedTextColor = TextHigh,
            cursorColor = AccentCyan
        ),
        singleLine = true
    )
}

@Composable
fun StatsRow(nodes: Int, mastered: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Surface(
            shape = CircleShape,
            color = Color(0xFF0F172A)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text("NODES: $nodes", style = MaterialTheme.typography.labelMedium, color = TextMed)
                Text("MASTERED: $mastered", style = MaterialTheme.typography.labelMedium, color = AccentGreen)
            }
        }
    }
}

@Composable
fun VocabularyCardWrapper(
    word: VocabularyWord,
    isMobileLess: Boolean,
    onPlayAudio: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val cardPadding = if (isMobileLess) 12.dp else 16.dp
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { expanded = !expanded },
        colors = CardDefaults.cardColors(containerColor = BgCard),
        border = BorderStroke(1.dp, BorderColor)
    ) {
        Column(modifier = Modifier.padding(cardPadding)) {
            // Header: Word + Audio
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = word.german,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = if (isMobileLess) 15.sp else 17.sp
                    ),
                    color = TextHigh,
                    modifier = Modifier.weight(1f, fill = false)
                )
                
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(if (isMobileLess) 4.dp else 8.dp)
                ) {
                    if (word.pronunciation != "-") {
                        Text(
                            text = "\"${word.pronunciation}\"",
                            style = MaterialTheme.typography.labelMedium.copy(
                                fontSize = if (isMobileLess) 10.sp else 12.sp
                            ),
                            color = Color(0xFFCBD5E1)
                        )
                    }
                    
                    IconButton(
                        onClick = { onPlayAudio(word.german) },
                        modifier = Modifier
                            .size(if (isMobileLess) 24.dp else 28.dp)
                            .background(ButtonBg, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Listen to pronunciation",
                            tint = AccentCyan,
                            modifier = Modifier.size(if (isMobileLess) 12.dp else 16.dp)
                        )
                    }

                    // Rotating arrow-right-style button
                    val rotation by animateFloatAsState(if (expanded) 0f else -90f, label = "expansionIcon")
                    IconButton(
                        onClick = { expanded = !expanded },
                        modifier = Modifier
                            .size(if (isMobileLess) 24.dp else 28.dp)
                            .background(ButtonBg, CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Toggle examples and usage",
                            tint = AccentCyan,
                            modifier = Modifier
                                .rotate(rotation)
                                .size(if (isMobileLess) 12.dp else 16.dp)
                        )
                    }
                }
            }
            
            Text(
                text = word.english,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = if (isMobileLess) 13.sp else 14.sp
                ),
                color = TextMed,
                modifier = Modifier.padding(top = 4.dp)
            )
            
            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Column(modifier = Modifier.padding(top = 12.dp)) {
                    // Sentence / Examples
                    if (word.examples.isNotEmpty()) {
                        Text(
                            text = "EXAMPLES SENTENCES",
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontSize = if (isMobileLess) 9.sp else 11.sp
                            ),
                            color = AccentCyan,
                            modifier = Modifier.padding(bottom = 6.dp)
                        )
                        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            word.examples.forEach { example ->
                                Column {
                                    Text(
                                        text = example.german,
                                        style = MaterialTheme.typography.bodySmall.copy(
                                            fontSize = if (isMobileLess) 11.sp else 12.sp
                                        ),
                                        color = TextHigh
                                    )
                                    if (example.english.isNotEmpty()) {
                                        Text(
                                            text = example.english,
                                            style = MaterialTheme.typography.bodySmall.copy(
                                                fontStyle = FontStyle.Italic,
                                                fontSize = if (isMobileLess) 10.sp else 11.sp
                                            ),
                                            color = TextMed
                                        )
                                    }
                                }
                                HorizontalDivider(color = BorderColor, modifier = Modifier.padding(vertical = 4.dp))
                            }
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                    
                    // Usage
                    Text(
                        text = "USAGE & CLASSIFICATION",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = if (isMobileLess) 9.sp else 11.sp
                        ),
                        color = AccentCyan,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = word.systemData,
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = if (isMobileLess) 11.sp else 12.sp
                        ),
                        color = TextMed
                    )
                }
            }
        }
    }
}

@Composable
fun FooterStatusBar() {
    Column {
        HorizontalDivider(color = BorderColor, modifier = Modifier.padding(top = 24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("ID: GREETINGS", style = MaterialTheme.typography.labelMedium, color = TextLow)
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Box(modifier = Modifier.size(8.dp).background(AccentGreen, CircleShape))
                Text("SYNC_COMPLETE", style = MaterialTheme.typography.labelMedium, color = AccentGreen)
            }
        }
    }
}
