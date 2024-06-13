package com.example.health_tracker.ui.theme.Screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.health_tracker.R
import com.example.health_tracker.datastore.StoreAge
import com.example.health_tracker.datastore.StoreGoal
import com.example.health_tracker.datastore.StoreHeight
import com.example.health_tracker.datastore.StoreName
import com.example.health_tracker.datastore.StoreSurname
import com.example.health_tracker.datastore.StoreWeight
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch



@Composable
fun ProfileSettings(navController: NavController){ // TODO: Remove comment
    //Popups
    val passwordPopup = remember { mutableStateOf(false) }
    val currentPassword = remember { mutableStateOf("") }
    val namePopup = remember { mutableStateOf(false) }
    val currentName = remember { mutableStateOf("") }
    val surnamePopup = remember { mutableStateOf(false) }
    val currentSurname = remember { mutableStateOf("") }
    val agePopup = remember { mutableStateOf(false) }
    val currentAge = remember { mutableStateOf( 0 ) }
    val weightPopup = remember { mutableStateOf(false) }
    val currentWeight = remember { mutableStateOf(0.0) }
    val heightPopup = remember { mutableStateOf(false) }
    val currentHeight = remember { mutableStateOf(0) }
    val goalPopup = remember { mutableStateOf(false) }
    val currentGoal = remember { mutableStateOf(0.0) }

    //Context
    val context = LocalContext.current
    //Scope
    val scope = rememberCoroutineScope()

    val nameStore = StoreName(context)
    val surnameStore = StoreSurname(context)
    val ageStore = StoreAge(context)
    val weightStore = StoreWeight(context)
    val heightStore = StoreHeight(context)
    val goalStore = StoreGoal(context)



    LaunchedEffect(Unit) {
        launch {
            val initialValue = nameStore.getName
            currentName.value = initialValue.first()!!
        }
    }
    LaunchedEffect(Unit) {
        launch {
            val initialValue = surnameStore.getSurname
            currentSurname.value = initialValue.first()!!
        }
    }
    LaunchedEffect(Unit) {
        launch {
            val initialValue = ageStore.getAge
            currentAge.value = initialValue.first()!!
        }
    }
    LaunchedEffect(Unit) {
        launch {
            val initialValue = weightStore.getWeight
            currentWeight.value = initialValue.first()!!
        }
    }
    LaunchedEffect(Unit) {
        launch {
            val initialValue = heightStore.getHeight
            currentHeight.value = initialValue.first()!!
        }
    }
    LaunchedEffect(Unit) {
        launch {
            val initialValue = goalStore.getGoal
            currentGoal.value = initialValue.first()!!
        }
    }


    //Conditions
    if (passwordPopup.value){
        PasswordPopUp(passwordPopup = passwordPopup, currentPassword = currentPassword)
    }
    if (namePopup.value){
        NamePopUp(namePopup = namePopup, currentName = currentName,
            scope = scope, datastore = nameStore)
    }

    if (surnamePopup.value){
        SurnamePopUp(surnamePopup = surnamePopup, currentSurname = currentSurname,
            scope = scope, datastore = surnameStore)
    }
    if (agePopup.value) {
        AgePopUp(agePopup = agePopup, currentAge = currentAge, scope = scope, datastore = ageStore)
    }
    if (weightPopup.value) {
        WeightPopUp(weightPopup = weightPopup, currentWeight = currentWeight,
            scope = scope, datastore = weightStore)
    }
    if (heightPopup.value) {
        HeightPopUp(heightPopup = heightPopup, currentHeight = currentHeight,
            scope = scope, datastore = heightStore)
    }
    if (goalPopup.value) {
        GoalPopUp(goalPopup = goalPopup, currentGoal = currentGoal,
            scope = scope, datastore = goalStore)
    }
    //Colors
    val gradientColors = listOf(
        Color(0xFFFFEBD4),
        Color(0xFFFCE0D7),
        Color(0xFFFFFDC5)
    )
    //Background
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = gradientColors)
            )
    ) {
        val gradientColors = listOf(
            Color(0xFFFFEBD4),
            Color(0xFFFCE0D7),
            Color(0xFFFFFDC5)
        )
        Column(modifier = Modifier.fillMaxSize()) {
            //Settings Box
            Card(modifier = Modifier
                .padding(top = 60.dp, start = 10.dp)
                .width(370.dp)
                .height(670.dp)
                .shadow(shape = RoundedCornerShape(10.dp), elevation = 10.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = gradientColors
                    ),
                    shape = RoundedCornerShape(10.dp)
                ),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.dark_gray)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 8.dp
                )
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFC8E3ED))
                    ){
                    //Top right close button
//                    Row(modifier = Modifier
//                        .align(Alignment.TopEnd)) {
//
//                    }
                    //Username row
                    //Password row
                    Row(
                        modifier = Modifier

                            .padding(top = 100.dp, start = 20.dp)
                            .clickable {
                                passwordPopup.value = true
                            }
                    ) {
                        Text(
                            text = stringResource(id = R.string.password_column),
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = currentPassword.value,
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                    }
                    //Name row
                    Row(
                        modifier = Modifier

                            .padding(top = 50.dp, start = 20.dp)
                            .clickable {
                                namePopup.value = true
                            }
                    ) {
                        Text(
                            text = stringResource(id = R.string.name_column),
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = currentName.value,
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                    }
                    //Surname row
                    Row(
                        modifier = Modifier

                            .padding(top = 50.dp, start = 20.dp)
                            .clickable {
                                surnamePopup.value = true
                            }
                    ) {
                        Text(
                            text = stringResource(id = R.string.surname_column),
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = currentSurname.value,
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                    }
                    //Age row
                    Row(
                        modifier = Modifier

                            .padding(top = 50.dp, start = 20.dp)
                            .clickable {
                                agePopup.value = true
                            }
                    ) {
                        Text(
                            text = stringResource(id = R.string.age_column),
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = currentAge.value.toString(),
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                    }
                    //Weight row
                    Row(
                        modifier = Modifier

                            .padding(top = 50.dp, start = 20.dp)
                            .clickable {
                                weightPopup.value = true
                            }
                    ) {
                        Text(
                            text = stringResource(id = R.string.weight_column),
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = currentWeight.value.toString(),
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                    }
                    //Height row
                    Row(
                        modifier = Modifier

                            .padding(top = 50.dp, start = 20.dp)
                            .clickable {
                                heightPopup.value = true
                            }
                    ) {
                        Text(
                            text = stringResource(id = R.string.height_column),
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = currentHeight.value.toString(),
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                    }
                    //Goal row
                    Row(
                        modifier = Modifier

                            .padding(top = 50.dp, start = 20.dp)
                            .clickable {
                                goalPopup.value = true
                            }
                    ) {
                        Text(
                            text = stringResource(id = R.string.goal_column),
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = currentGoal.value.toString(),
                            style = TextStyle(
                                color = colorResource(id = R.color.black),
                                fontSize = 20.sp
                            )
                        )
                    }
                }
            }
            Button(onClick = {navController.popBackStack()},// TODO: Remove comment
                colors = ButtonColors(
                    containerColor = Color(0xFFC8E3ED),
                    contentColor = Color.Black,
                    disabledContainerColor = Color(0xFFC8E3ED),
                    disabledContentColor = Color.Black),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
                modifier = Modifier
                    .padding(start = 270.dp, top = 20.dp)
            ) {
                Text(
                    text = "Back",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.width(5.dp))
                Image(painter = painterResource(id = R.drawable.turn_back_1),
                    contentDescription = "Turn back icon",
                    modifier = Modifier
                        .size(20.dp))
            }

        }



    }

}


//@Composable
//fun UsernamePopUp(
//    usernamePopup: MutableState<Boolean>,
//    currentUsername: MutableState<String>,
//    scope : CoroutineScope,
//    datastore : StoreUsername,
//    ){
//    if(usernamePopup.value){
//        Dialog(onDismissRequest = { usernamePopup.value = false}) {
//            Surface(
//                modifier = Modifier
//                    .fillMaxWidth(0.8f)
//                    .background(color = Color.Transparent)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .padding(16.dp)
//                ) {
//                    Text(
//                        text = "Edit Username",
//                        style = MaterialTheme.typography.bodyMedium)
//
//                    Spacer(modifier = Modifier.height(8.dp))
//
//                    TextField(
//                        value = currentUsername.value.toString(),
//                        onValueChange = {
//                            val newValue = it
//                            currentUsername.value = newValue
//                            scope.launch {
//                                datastore.saveUsername(newValue)
//                            }
//
//                        })
//
//                    Spacer(modifier = Modifier.height(16.dp))
//
//                    Row(modifier = Modifier){
//                        Button(onClick = { usernamePopup.value = false}) {
//                            Text(text = "Cancel")
//                        }
//
//                        Spacer(modifier = Modifier.size(53.dp))
//
//                        Button(onClick = {usernamePopup.value = false}) {
//                            Text(text = "Save")
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

@Composable
fun PasswordPopUp(passwordPopup: MutableState<Boolean>,
                  currentPassword: MutableState<String>
){
    if(passwordPopup.value){
        Dialog(onDismissRequest = { passwordPopup.value = false}) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(color = Color.Transparent)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Edit Username",
                        style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = currentPassword.value.toString(),
                        onValueChange = {
                            val newValue = it
                            currentPassword.value = newValue
                        })

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier){
                        Button(onClick = { passwordPopup.value = false}) {
                            Text(text = "Cancel")
                        }

                        Spacer(modifier = Modifier.size(53.dp))

                        Button(onClick = {passwordPopup.value = false}) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NamePopUp(namePopup: MutableState<Boolean>,
              currentName: MutableState<String>,
              scope: CoroutineScope,
              datastore: StoreName
 ){
    if(namePopup.value){
        val newName = remember { mutableStateOf("") }
        newName.value = currentName.value
        Dialog(onDismissRequest = { namePopup.value = false}) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(color = Color.Transparent)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Edit Username",
                        style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = newName.value,
                        onValueChange = {
                            val newValue = it
                            newName.value = newValue
                        })

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier){
                        Button(onClick = { namePopup.value = false}) {
                            Text(text = "Cancel")
                        }

                        Spacer(modifier = Modifier.size(53.dp))

                        Button(onClick = {
                            currentName.value = newName.value
                            scope.launch{
                                datastore.saveName(newName.value)
                            }
                            namePopup.value = false}
                        ) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SurnamePopUp(surnamePopup: MutableState<Boolean>,
                 currentSurname: MutableState<String>,
                 scope: CoroutineScope,
                 datastore: StoreSurname
){
    val newSurname = remember { mutableStateOf("") }
    newSurname.value = currentSurname.value
    if(surnamePopup.value){
        Dialog(onDismissRequest = { surnamePopup.value = false}) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(color = Color.Transparent)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Edit Username",
                        style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = newSurname.value.toString(),
                        onValueChange = {
                            val newValue = it
                            newSurname.value = newValue
                        })

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier){
                        Button(onClick = { surnamePopup.value = false}) {
                            Text(text = "Cancel")
                        }

                        Spacer(modifier = Modifier.size(53.dp))

                        Button(onClick = {
                            currentSurname.value = newSurname.value
                            scope.launch {
                                datastore.saveSurname(newSurname.value)
                            }
                            surnamePopup.value = false}
                        ) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AgePopUp(
    agePopup: MutableState<Boolean>,
    currentAge: MutableState<Int>,
    scope: CoroutineScope,
    datastore: StoreAge
){
    val newAge = remember {
        mutableStateOf(0)
    }
    newAge.value = currentAge.value
    if(agePopup.value){
        Dialog(onDismissRequest = { agePopup.value = false}) {
            Surface(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .background(color = Color.Transparent)
            ) {
                Column(
                        modifier = Modifier
                                .padding(16.dp)
                ) {
                    Text(
                            text = "Edit Username",
                            style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                            value = newAge.value.toString(),
                            onValueChange = {
                                val newValue = it.toIntOrNull() ?: 0
                                newAge.value = newValue
                            },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier){
                        Button(onClick = { agePopup.value = false}) {
                            Text(text = "Cancel")
                        }

                        Spacer(modifier = Modifier.size(53.dp))

                        Button(onClick = {
                            currentAge.value = newAge.value
                            scope.launch {
                                datastore.saveAge(newAge.value)
                            }
                            agePopup.value = false
                        }) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WeightPopUp(
    weightPopup: MutableState<Boolean>,
    currentWeight: MutableState<Double>,
    scope: CoroutineScope,
    datastore: StoreWeight
){

    val newWeight = remember {
        mutableStateOf(0.0)}
    newWeight.value = currentWeight.value
    if(weightPopup.value){
        Dialog(onDismissRequest = { weightPopup.value = false}) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(color = Color.Transparent)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Edit Username",
                        style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = newWeight.value.toString(),
                        onValueChange = {
                            val newValue = it.toDoubleOrNull() ?: 0.0
                            newWeight.value = newValue
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier){
                        Button(onClick = { weightPopup.value = false}) {
                            Text(text = "Cancel")
                        }

                        Spacer(modifier = Modifier.size(53.dp))

                        Button(onClick = {
                            currentWeight.value = newWeight.value
                            scope.launch {
                                datastore.saveWeight(newWeight.value)
                            }
                            weightPopup.value = false
                        }) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun HeightPopUp(
    heightPopup: MutableState<Boolean>,
    currentHeight: MutableState<Int>,
    scope: CoroutineScope,
    datastore: StoreHeight
){
    val newHeight = remember {
        mutableStateOf(0)}
    newHeight.value = currentHeight.value
    if(heightPopup.value){
        Dialog(onDismissRequest = { heightPopup.value = false}) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(color = Color.Transparent)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Edit Username",
                        style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = currentHeight.value.toString(),
                        onValueChange = {
                            val newValue = it.toIntOrNull() ?: 0
                            newHeight.value = newValue
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier){
                        Button(onClick = { heightPopup.value = false}) {
                            Text(text = "Cancel")
                        }

                        Spacer(modifier = Modifier.size(53.dp))

                        Button(onClick = {
                            currentHeight.value = newHeight.value
                            scope.launch {
                                datastore.saveHeight(newHeight.value)
                            }
                            heightPopup.value = false
                        }) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GoalPopUp(
    goalPopup: MutableState<Boolean>,
    currentGoal: MutableState<Double>,
    scope: CoroutineScope,
    datastore: StoreGoal
){
    val newGoal = remember {
        mutableStateOf(0.0)}
    newGoal.value = currentGoal.value
    if(goalPopup.value){
        Dialog(onDismissRequest = { goalPopup.value = false}) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(color = Color.Transparent)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Edit Username",
                        style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = newGoal.value.toString(),
                        onValueChange = {
                            val newValue = it.toDoubleOrNull() ?: 0.0
                            newGoal.value = newValue
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(modifier = Modifier){
                        Button(onClick = { goalPopup.value = false}) {
                            Text(text = "Cancel")
                        }

                        Spacer(modifier = Modifier.size(53.dp))

                        Button(onClick = {
                            currentGoal.value = newGoal.value
                            scope.launch {
                                datastore.saveGoal(newGoal.value)
                            }
                            goalPopup.value = false
                        }) {
                            Text(text = "Save")
                        }
                    }
                }
            }
        }
    }
}


