package com.example.firstkotlinpracticeapp

/*
탐색 담당 컴포저블 안에서 화면에 접근하는것을 원함
서브 클래스의 자료형 중 하나를 따르는 자료형인것을 미리 알 수 있을때 사용
sealed 클래스는 런타임이 아니라 컴파일할 때 일치하는 자료형으로 제한하여,
자료형의 안정성을 보장하는데, 이를 통해 실수로 경로 이름을 틀렸다면
경로를 호출할때 문제가 발생하지 않도록 할 수 있다.
*/
sealed class FoodSealedScreen(val route: String) {
    object RecipeScreen : FoodSealedScreen(route = "recipesscreen")
    object DetailScreen : FoodSealedScreen(route = "fooddetailscreen")
}