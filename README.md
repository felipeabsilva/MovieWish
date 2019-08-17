# MovieWish

Application Layers:

<b>Adapter:</b> Includes the recycler view adapters and viewholders, responsible for creating the movies and genres list.
  
<b>Data:</b> Includes database package, which manages all the data received from API. Includes model package, providing the data model for the API requests.
  
<b>Remote:</b> Build and Manage the API requests.
  
<b>Repository:</b> It's the connection between the functions provided from Database to ViewModel.
  
<b>Utilities:</b> It has some object extensions and Constants which makes the functions handle easier.
  
<b>View:</b> Includes all the app views, which manages the UI changes.
  
<b>ViewModel:</b> Provides to View all it needs to manage the UI changes.

<b>Libraries:</b>
<br>
Kodein as Dependecy Injection
<br>
Retrofit as API Request and Cache
<br>
GsonConverter as JSON Manager
<br>
Glide as Image Loader
  
<b>1. What is the principle of sole responsibility? What's its purpose?</b>
<br>
It's about each class be responsible for just one thing. It makes the code interpretation, implementation, and maintenance easier.
  
<b>2. What characteristics does, in your opinion, have a "good" code or clean code?</b>
<br>
Each class needs to have a sole responsability.
<br>
The project follows some development pattern (like MVVM or MVP)
<br>
The variables and functions name are self explanatory.
<br>
All the ids follow some pattern, like (view tipe + layout name + view reference. E.g.: image_main_movie)
<br>
All the strings are extracted to the strings file.
<br>
Code reuse and object extensions.
