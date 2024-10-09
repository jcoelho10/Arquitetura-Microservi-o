// data.js para MongoDB (Order Service)
db.orders.insertMany([
    { _id: ObjectId(), orderNumber: 'ORD001', product: 'Laptop', quantity: 1 },
    { _id: ObjectId(), orderNumber: 'ORD002', product: 'Smartphone', quantity: 2 }
]);
