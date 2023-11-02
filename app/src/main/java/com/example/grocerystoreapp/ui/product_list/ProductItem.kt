package com.example.grocerystoreapp.ui.product_list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grocerystoreapp.data.Product

@Composable
fun ProductItem(
	product : Product, onEvent : (ProductListEvent) -> Unit, modifier : Modifier = Modifier
) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.clip(shape = RoundedCornerShape(15.dp))
			.background(Color.Cyan, shape = RoundedCornerShape(15.dp))
			.padding(horizontal = 10.dp)
			.clickable { onEvent(ProductListEvent.OnProductClick(product)) }
	) {
		Row(
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween,
			modifier = Modifier.fillMaxWidth()
		) {
			Text(text = product.name)
			Text(text = product.quantity)

			Text(text = product.price)
			IconButton(onClick = { onEvent(ProductListEvent.OnDeleteProduct(product)) }) {
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
			Text(text = "${product.price.toFloat()*product.quantity.toFloat()} ")
		}
	}
} //@Preview(showBackground = true)
//@Composable
//private fun ProductItemPreview(
//) {
//	ProductItem()
//
//
//}