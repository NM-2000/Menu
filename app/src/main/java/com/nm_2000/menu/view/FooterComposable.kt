package com.nm_2000.menu.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavHostController
import com.nm_2000.menu.ui.theme.Footer_Color

@Composable
fun FooterComposable(
    navController: NavHostController,
    activeTab: String,
    setActiveTab: (String) -> Unit
) {
    val constraints = ConstraintSet {
        val tabOne = createRefFor("tabOne")
        val tabTwo = createRefFor("tabTwo")
        val tabThree = createRefFor("tabThree")
        val tabFour = createRefFor("tabFour")
        val tabFive = createRefFor("tabFive")
        constrain(tabOne) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(tabTwo.start)
        }
        constrain(tabTwo) {
            top.linkTo(parent.top)
            start.linkTo(tabOne.end)
            end.linkTo(tabThree.start)
        }
        constrain(tabThree) {
            top.linkTo(parent.top)
            start.linkTo(tabTwo.end)
            end.linkTo(tabFour.start)
        }
        constrain(tabFour) {
            top.linkTo(parent.top)
            start.linkTo(tabThree.end)
            end.linkTo(tabFive.start)
        }
        constrain(tabFive) {
            top.linkTo(parent.top)
            start.linkTo(tabFour.end)
            end.linkTo(parent.end)
        }
        createHorizontalChain(
            tabOne,
            tabTwo,
            tabThree,
            tabFour,
            tabFive,
            chainStyle = ChainStyle.SpreadInside
        )
    }
    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Footer_Color)
            .padding(32.dp, 14.dp, 32.dp, 44.dp)
    ) {
        FooterButton(
            "tabOne",
            activeTab,
            setActiveTab,
            true,
            navController,
            Orientation.ListOrientation.route
        )
        FooterButton(
            "tabTwo",
            activeTab,
            setActiveTab,
            true,
            navController,
            Orientation.GridOrientation.route
        )
        FooterButton("tabThree", activeTab, setActiveTab, false, navController)
        FooterButton("tabFour", activeTab, setActiveTab, false, navController)
        FooterButton("tabFive", activeTab, setActiveTab, false, navController)
    }
}