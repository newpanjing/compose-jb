import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.web.css.margin
import androidx.compose.web.css.percent
import androidx.compose.web.css.px
import androidx.compose.web.css.width
import androidx.compose.web.elements.A
import androidx.compose.web.elements.Button
import androidx.compose.web.elements.Div
import androidx.compose.web.elements.Text
import androidx.compose.web.renderComposable
import kotlinx.browser.window
import react.dom.render

@Composable
fun YoutubeReactPlayerWrapper(videoUrl: String) {
    if (videoUrl.isEmpty()) return
    Div(
        style = {
            width(50.percent)
        }
    ) {
        DomSideEffect(videoUrl) { htmlDivElement ->
            render(htmlDivElement) {
                reactPlayer {
                    attrs.url = videoUrl
                }
            }
        }
    }
}

private val videos = listOf(
    "https://www.youtube.com/watch?v=UryyHq45Y_8",
    "https://www.youtube.com/watch?v=698I_AH8h6s",
    "https://www.youtube.com/watch?v=F8jj7e-_jFA"
)

fun reactInComposeAppExample() {
    var videoUrl by mutableStateOf("")

    renderComposable(rootElementId = "root") {

        A(href = "${window.location.origin}?app=reactApp") { Text("GO TO COMPOSE IN REACT EXAMPLE") }

        Div {
            videos.forEachIndexed { ix, url ->
                Button(
                    attrs = {
                        onClick { videoUrl = url }
                    },
                    style = {
                        margin(10.px)
                    }
                ) { Text("Video ${ix + 1}") }
            }

            YoutubeReactPlayerWrapper(videoUrl)
        }
    }
}