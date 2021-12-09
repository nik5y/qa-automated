Feature: Buy Various Items
	I want to search for various items on the Clothing Website

	Scenario Outline: Buy "<Item>"
		Given I can access the Clothing Website
		When I search for the "<Item>"
		And Get the text of the first result
		And Add the first result to cart
		And Go to checkout from results page
		And Continue checkout after Order Summary
		And Log in
		And Continue checkout after Order Address
		And Agree with Terms and Conditions
		And Continue checkout after Order Shipping
		And Choose payment as Bank Wire
		And Confirm Order
		Then I can see that Order is complete
		
		Examples:
			| Item |
			| dress |
			| blouse |