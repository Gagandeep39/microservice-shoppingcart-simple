# Product Service 

## Fetch All
GET localhost:5001/products

## Fetch By ID
GET localhost:5001/products/{id}

## Fetch by Category
GET localhost:5001/products/category/{category}

## Update Stock 
POST localhost:5001/products/{productId}/{quantity}

# Cart Service

5002
## Fetch By ID
GET localhost:5002/carts/{cartId}

## Save to Cart 
POST localhost:5002/carts/{cartId}
```
{
    "id": 1,
    "stock": 50,
    "name": "OnePlus 7",
    "category": "Electronics"
}
```
## Create Cart 
POST localhost:5002/carts

## Delete item from cart
POST localhost:5002/carts/{cartId}/{productId}

## Deduct product stocks on checkout 
POST localhost:5002/carts/checkout/{cartId}