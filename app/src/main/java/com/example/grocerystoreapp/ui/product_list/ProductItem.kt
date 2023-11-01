package com.example.grocerystoreapp.ui.product_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grocerystoreapp.data.Product

@Composable
fun ProductItem( //	product : Product,
	//	onEvent : (ProductListEvent)->Unit,
	//	modifier : Modifier=Modifier
) {
	Column(modifier = Modifier.fillMaxWidth().background(shape = RoundedCornerShape(8.dp))) {
		Row(
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween,
			modifier = Modifier.fillMaxWidth()
		) {
			Text(text = "Onions")
			Text(text = "10")

			Text(text = "20£")
			IconButton(onClick = { /*TODO*/ }) {
				Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
			}
		}
		Spacer(modifier = Modifier.height(8.dp))
		Row(
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween,
			modifier = Modifier.fillMaxWidth()
		) {
			Text(text = "Total Cost")
			Text(text = "$100")
		}
	}

}
@Preview(showBackground = true)
@Composable
private fun ProductItemPreview(
) {
	ProductItem()


}