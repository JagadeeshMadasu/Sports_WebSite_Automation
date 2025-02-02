# Test Cases Documentation

## Overview
 It provides details of the automated test cases implemented using the **Page Object Model (POM)** with a **BaseTest class**. The test results are generated using **Extent Reports**.

---

## Test Case 1: Brand Product Comparison

**Test Name:** `testBrandProductComparison`  
**Description:** Validates the product comparison functionality by selecting two racquet products of any specific brand (**Babolat**) of minimum and maximum length and verifying that the selected products appear in the comparison list.

### **Test Steps:**
1. Launch the application.
2. Hover over the **Racquets** category.
3. Click on the **Babolat** brand.
4. Open the **length dropdown** and select the **minimum length** checkbox.
5. Add the **first product** to the comparison list.
6. Clear the **Filter**.
7. Open the **length dropdown** and select the **maximum length** checkbox.
8. Add the **second product** to the comparison list.
9. Navigate to the **comparison page**.
10. Validate that **both selected products appear** in the comparison list.
11. Remove **all products** from the comparison list.
12. Return to the **main page**.

### **Expected Result:**
Both selected products should appear in the **comparison list**, and they should be successfully removed.

---

## Test Case 2: Add and Remove Shoes from Cart

**Test Name:** `testAddandRemoveShoes`  
**Description:** Verifies that a product can be added to the shopping cart and then removed successfully.

### **Test Steps:**
1. Launch the application.
2. Click on the **Nike Shoes** category.
3. Select a **NEW label product** from the list.
4. Add the selected product to the **cart**.
5. Navigate to the **cart page**.
6. Remove the product from the **cart**.
7. Verify that the **cart is empty**.
8. Close the **cart view**.
9. Return to the **main page**.

### **Expected Result:**
The product should be successfully **added to the cart**, removed, and the cart should display an empty message:  
`"You have no items in your shopping cart."`

---

## Test Case 3: Product Search

**Test Name:** `testSearchFunctionality`  
**Description:** Validates the search functionality by checking if the entered search term returns the correct product result.

### **Test Steps:**
1. Define the **search text**: `"WILSON TOUR PREMIER BALLS CAN"`.
2. Launch the application.
3. Enter the **search text** into the **search bar**.
4. Retrieve the **search result product name**.
5. Validate that the retrieved **product name matches the search text**.
6. Return to the **main page**.

### **Expected Result:**
The product displayed in the **search results** should **match the search query exactly**.

---

## **Framework Components Used**
- **Page Object Model (POM):** Ensures better test maintainability and reusability.
- **BaseTest Class:** Contains common setup and teardown methods for test execution.
- **Extent Reports:** Generates structured HTML reports for test execution results.
- **Maven:** Building and running the tests.
- **TestNG:** Running the tests and validation of expected vs. actual results.
- **Language:** Java  
- **Browser:** Chrome
