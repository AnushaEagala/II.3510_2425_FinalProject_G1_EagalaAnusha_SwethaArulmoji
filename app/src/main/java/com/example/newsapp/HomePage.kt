package com.example.newsapp

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.utils.shareViaGmail
import com.example.newsapp.utils.shareViaSMS
import com.example.newsapp.utils.shareViaSocialMedia

@Composable
fun HomePage(
    onNavigateToProfile: () -> Unit,
    onNavigateToConnectionsGraph: () -> Unit,
    onNavigateToScreenTimeGraph: () -> Unit
) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    val onShareGmail = {
        shareViaGmail(context, "Subject for Gmail", "Body content for Gmail")
    }
    val onShareSMS = {
        shareViaSMS(context, "Body content for SMS")
    }
    val onShareSocial = {
        shareViaSocialMedia(context, "Subject for Social Media", "Body content for Social Media")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top Section with menu and dropdown
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { expanded = !expanded }) {
                        Image(
                            painter = painterResource(id = R.drawable.menu_icon),
                            contentDescription = "Menu Icon",
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    IconButton(onClick = onShareGmail) {
                        Image(
                            painter = painterResource(id = R.drawable.share_icon),
                            contentDescription = "Share Icon",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }

                Text(
                    text = "Welcome to the Home Page",
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 24.sp
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.width(250.dp)
                ) {
                    DropdownMenuItem(
                        text = { Text("View Connections") },
                        onClick = {
                            onNavigateToConnectionsGraph()
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("View Screen Time") },
                        onClick = {
                            onNavigateToScreenTimeGraph()
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Go to Profile") },
                        onClick = {
                            onNavigateToProfile()
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Share via Gmail") },
                        onClick = {
                            onShareGmail()
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Share via SMS") },
                        onClick = {
                            onShareSMS()
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Share on Social Media") },
                        onClick = {
                            onShareSocial()
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}
