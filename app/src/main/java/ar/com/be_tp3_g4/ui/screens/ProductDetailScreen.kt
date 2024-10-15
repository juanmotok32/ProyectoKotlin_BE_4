package ar.com.be_tp3_g4.ui.screens

import CustomBottomNavBarPreview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.com.be_tp3_g4.R
import ar.com.be_tp3_g4.model.Product
import ar.com.be_tp3_g4.ui.components.Btn
import ar.com.be_tp3_g4.ui.components.TopAppBar
import ar.com.be_tp3_g4.ui.components.Counter
import ar.com.be_tp3_g4.ui.theme.BE_TP3_G4Theme
import logout

@Composable
fun ProductDetailScreen(product: Product, onAddToCart: () -> Unit) {
    Scaffold(containerColor = MaterialTheme.colorScheme.primary,
        topBar = {
            TopAppBar(tittle = R.string.product_detail, menu = { })
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary),

                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = product.image),
                        contentDescription = product.name,
                        modifier = Modifier
                            .size(250.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(16.dp),
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = product.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    Text(
                        text = product.content,
                        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 14.sp),
                        color = MaterialTheme.colorScheme.inversePrimary,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Counter()
                        Text(
                            text = "\$${product.price}",
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 25.sp),
                            color = MaterialTheme.colorScheme.inversePrimary,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(10.dp)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                Divider(thickness = 1.dp, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(15.dp))
                Row {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Product Detail",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.Start)
                        )
                        Text(
                            text = product.description,
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 10.sp),
                            modifier = Modifier.align(Alignment.Start)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Divider(thickness = 1.dp, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Nutritions",
                            fontWeight = FontWeight.Bold
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Button(
                                onClick = { /* Acción 100g */ },
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                                    .height(30.dp)
                            ) {
                                Text(
                                    text = "100g",
                                    style = MaterialTheme.typography.bodyLarge.copy(fontSize = 12.sp),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                            Icon(
                                painter = painterResource(id = R.drawable.flecha),
                                contentDescription = "Star Rating"
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))
                Divider(thickness = 1.dp, color = MaterialTheme.colorScheme.tertiary)
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Review",
                        fontWeight = FontWeight.Bold
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "Additional Icon",
                            tint = Color(0xFFF3603F)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.flecha),
                            contentDescription = "Star Rating"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Spacer(modifier = Modifier.weight(1f))
                Btn(
                    onClick = { onAddToCart },
                    text = R.string.add_basket,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }, modifier = Modifier.background(MaterialTheme.colorScheme.primary)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewProductDetailScreen() {
    BE_TP3_G4Theme {
        val exampleProduct = Product(
            name = "Coca-Cola",
            brand = "Coca-Cola",
            price = 1.50f,
            image = R.drawable.diet_coke,
            description = "Refresco gaseoso sabor cola",
            content = "330ml",
            category = "Beverages"
        )
        ProductDetailScreen(
            product = exampleProduct,
            onAddToCart = { /* Acción agregar al carrito */ })
    }
}



