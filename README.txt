Using test first development, this program will fetch text data from the URL given below,
extract relevant details, and print the following:

Unix time is X

where X is the value next to "unixtime: " in the text returned when a request is made to the URL.

If the program runs into an error making the network call, then gracefully display

Error: Y

where Y is the actual error from making the request to the URL.

Follow good design principles to allow for changing the service that will provide the data for Unix time.

URL: http://worldtimeapi.org/api/ip.txt
