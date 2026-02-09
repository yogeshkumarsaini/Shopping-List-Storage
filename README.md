# 🛒 Shopping List Storage System

A console-based **Shopping List Manager** built using Java.  
This application helps users manage their shopping items, track expenses, and store data using file handling.

---

## 🚀 Features

- ➕ Add shopping items  
- 📋 View shopping list  
- 🔍 Search items  
- ✏️ Edit item quantity  
- 🔤 Sort items alphabetically (A–Z)  
- 📂 Categorize items (Groceries, Electronics, etc.)  
- ✔ Mark items as purchased  
- 🧹 Delete all purchased items  
- 📊 Show total items count  
- 💰 Calculate total shopping cost  
- 💾 Save & load data from file  

---

## 🧱 Technologies Used

- Java  
- OOP (Object-Oriented Programming)  
- ArrayList Collection  
- File Handling (BufferedReader & BufferedWriter)  
- Exception Handling  
- Menu-driven Console UI  

---

## 📁 Project Structure

```
ShoppingList/
│
├── ShoppingItem.java # Model class for items
├── ShoppingListManager.java # Business logic & file handling
└── Main.java # User interface & menu system

```

---

## ▶ How to Run

1. Open the project in any Java IDE (IntelliJ, Eclipse, VS Code)  
2. Compile all files  
3. Run **Main.java**  

---

## 📝 Data Storage

The shopping list is saved in:
```
shopping_list.txt
```
Each line format:
```
ItemName,Quantity,PurchasedStatus,Category,Price
```
---

## 📸 Sample Menu

```
===== SHOPPING LIST MENU =====

1. Add Item
2. View List
3. Search Item
4. Edit Quantity
5. Sort A–Z
6. Show Items by Category
7. Delete Purchased Items
8. Show Total Item Count
9. Show Total Cost
10. Save List
11. Exit
```
