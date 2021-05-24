import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.web.elements.Div
import androidx.compose.web.elements.Text
import androidx.compose.web.renderComposable
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.html.InputType
import kotlinx.html.js.onClickFunction
import kotlinx.html.js.onInputFunction
import org.w3c.dom.HTMLElement
import react.*
import react.dom.*
import styled.css
import styled.styledDiv

@Composable
private fun ComposableComponentToUseInReact(count: State<Int>) {
    repeat(count.value) {
        Div {
            Text("Item $it")
        }
    }
}

private external interface ListProps : RProps {
    var countOfItems: Int
}

private val composeListComponentWrapper = functionalComponent<ListProps> { props ->

    // 1. Container reference where the composition will be mounted
    val containerRef = useRef<HTMLElement>(null)

    // 2. MutableState for Compose
    val mutableState = useRef(mutableStateOf(0))

    div {
        attrs {
            ref { containerRef.current = it }
        }

        useEffect {
            // 3.Mutable state needs to be updated
            mutableState.current?.value = props.countOfItems
        }

        // 4. pass constant 'dependencies' to let Compose control the DOM subtree
        useLayoutEffectWithCleanup(dependencies = emptyList()) {
            // 5. Mount composition using container
            val composition = renderComposable(containerRef.current!!) {
                ComposableComponentToUseInReact(mutableState.current!!)
            }

            return@useLayoutEffectWithCleanup {
                composition.dispose()
            }
        }
    }
}

private val column = functionalComponent<RProps> {
    val (counter, setCounter) = useState(0)

    styledDiv {
        css {
            padding = "25px"
        }

        h3 {
            +"Update items count using slider:"
        }

        input(type = InputType.range) {
            attrs {
                onInputFunction = {
                    setCounter(it.target?.asDynamic().value.toString().toInt())
                }
                value = "$counter"
            }
        }

        h3 {
            +"Compose controlled items:"
        }

        child(composeListComponentWrapper) {
            this.attrs {
                countOfItems = counter
            }
        }
    }
}

private val appContent = functionalComponent<RProps> {
    val (columnsCount, setColumnsCount) = useState(3)

    a(href = "${window.location.origin}?app=composeApp") {
        +"GO TO REACT IN COMPOSE EXAMPLE"
    }

    button {
        attrs {
            onClickFunction = {
                setColumnsCount(columnsCount - 1)
            }
        }
        +"Remove column"
    }

    button {
        attrs {
            onClickFunction = {
                setColumnsCount(columnsCount + 1)
            }
        }
        +"Add column"
    }

    styledDiv {
        css {
            display = Display.flex
            flexDirection = FlexDirection.row
        }

        repeat(columnsCount) {
            child(column)
        }
    }
}

fun composeInReactAppExample() {
    render(document.getElementById("root")) {
        child(appContent)
    }
}