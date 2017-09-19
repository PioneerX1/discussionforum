### Discussion Forum
    —

    MainActivity
    — lists Categories,
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
    Database Structure (Flat - all objects):
    - categories
    - messages
    - comments


    Models:
    1. category
     - category name
     - id

    2. messages
     - message title
     - full message
     - author
     - id
     - categoryId

    3. comments
     - full comment
     - id
     - messageId