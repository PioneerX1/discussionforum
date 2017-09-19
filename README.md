### Discussion Forum
    —

    Next Steps - Messages - Tues/Wed:
    - setup Category Detail Activity (& Fragments) - both classes and layouts
    - FirebaseMessageViewHolder
    - ?? Do we actually need a MessageListAdapter if using Firebase already ??
    - ?? Do we need a Fragment ?? example just uses it for phone and map icons
    - Model for Messages


    Next Step - Categories - Tues:
    - create a new category button/function in Main Activity  XXX
    - create a category model  XXX
    - create a category-list-item layout  XXX
    - link Firebase data to category_list_item layout …. prob with another file?? XXX
    - be able to write categories to Firebase  XXX


    Discussion Forum
    —

    Theme: For enthusiasts of stringed instruments (guitars, banjos, mandolins, steel guitars, etc.)

    MainActivity
    — lists App title and purpose
    - button to view categories

    Category List Page —
    —  lists Categories,
    - each has a click listener onClick - takes them to the messages
    - also Create a new category button

    Message List Page
    - lists all messages (in preview form) in the Category selected
    - Create a new message button
    - click listeners for each message preview to display full message

    Message Detail Page
    - displays Full message
    - displays all Comments for the message
    - option to submit a comment to the message


    —
    Database Structure (Flat):
    - categories
    - messages
    - comments


    Models:

    - category
    - category name
    - id

    - messages
    - message title
    - full message
    - author
    - id

    - categoryId
    - comments
    - full comment
    - id
    - messageId