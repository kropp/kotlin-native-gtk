/*
 * Copyright 2010-2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sample

import gtk3.*
import gtk3.Window
import libgtk3.*

fun main(args: Array<String>) {
    val application = Application("com.jetbrains.hackathon18.demo")

    application.onActivate {
//        fileManager().showAll()
        mainWindow()
    }

    application.run(args)
}

private fun Application.mainWindow() {
    createWindow {
        setDefaultSize(600, 400)
        iconName = "gtk-about"

        val adjustment = Adjustment(5.66, 0.0, 10.0, 0.1, 1.0, 1.0)
        var stackSwitcher: StackSwitcher? = null

        titlebar = HeaderBar().apply {
            title = "Hackathon Demo"
            subtitle = "Kotlin/Native + GTK"
            visible = true
            showCloseButton = true

            menuButton {
                popup = Menu().apply {
                    menuItem {
                        label = "Open"
                        onActivate {
                            //                                FileChooserDialog("Open File", this@createWindow.window, GtkFileChooserAction.GTK_FILE_CHOOSER_ACTION_OPEN, "Open!").show()
                        }
                    }

                    separatorMenuItem()

                    checkMenuItem {
                        label = "True"
                    }
                    checkMenuItem {
                        label = "False"
                    }
                    showAll()
                }.menu!!
            }

            stackSwitcher = stackSwitcher()
        }.widgetPtr!!

        var pentry: Entry? = null
        vbox {
            hbox {
                hbbox {
                    button {
                        label = "Quit"
                        onClicked {
                            println("Quit Kotlin GTK!")
                            this@createWindow.destroy()
                        }
                    }
                    button {
                        label = "File Manager"
                        onClicked {
                            fileManager().showAll()
                        }
                    }
                }

                hbbox {
                    vbbox {
                        toggleButton { label = "Toggle" }
                        switch()
                    }

                    vbox {
                        entry {
                            text = "Default text"
                        }
                        entry {
                            placeholderText = "Placeholder"
                        }
                        pentry = entry {
                            setIconFromIconName(GtkEntryIconPosition.GTK_ENTRY_ICON_PRIMARY, "view-refresh")
                        }
                        entry {
                            visibility = false
                        }
                    }
                }

                vbox {
                    spinner { start() }
                    spinButton(adjustment.widgetPtr, 0.1, 1U)
                }
            }

            frame("Buttons") {
                hbbox {
                    colorButton()
                    fileChooserButton("File", GtkFileChooserAction.GTK_FILE_CHOOSER_ACTION_OPEN)
                    fileChooserButton("Directory", GtkFileChooserAction.GTK_FILE_CHOOSER_ACTION_SELECT_FOLDER)
                    fontButton()
                }
            }

            stack {
                stackSwitcher?.stack = stack!!

                val cb = ButtonBox(GtkOrientation.GTK_ORIENTATION_VERTICAL).apply {
                    checkButton { label = "Checkbox 1" }
                    checkButton { label = "Checkbox 2"; active = true }
                    checkButton { label = "Checkbox 3" }
                }
                val rb = ButtonBox(GtkOrientation.GTK_ORIENTATION_VERTICAL).apply {
                    val r = radioButton(null) { label = "Radio 1" }
                    radioButton(null) { joinGroup(r); label = "Radio 2"; active = true }
                    radioButton(null) { joinGroup(r); label = "Radio 3" }
                }

                addTitled(cb, "t", "Toggles")
                addTitled(rb, "r", "Radios")
            }

            textView {
                val text = "Hello JetBrains!\n\nKotlin/Native\nGTK\n\nDEMO"
                libgtk3.gtk_text_buffer_set_text(buffer, text, text.length)
            }

            actionBar {
                imageButton("gtk-ok")
                imageButton("gtk-about") {
                    onClicked {
                        AboutDialog().apply {
                            iconName = "gtk-about"
                            authors = listOf("Victor Kropp", "John Doe")
                        }.show()
                    }
                }

                centerWidget = linkButton("https://jetbrains.com/") {
                    label = "jetbrains.com"
                }.widgetPtr!!

                val progress = progressBar {
                    fraction = .56
                    text = "Demo in progress"
                }
                adjustment.onValueChanged {
                    val fraction = adjustment.value / adjustment.upper
                    progress.fraction = fraction
                    pentry?.progressFraction = fraction
                }
            }
        }

    }.showAll()
}
