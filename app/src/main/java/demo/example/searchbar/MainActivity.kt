package demo.example.searchbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var search = findViewById<SearchView>(R.id.SearchBar)
        var listView = findViewById<ListView>(R.id.listView)

        var names = arrayOf("affenpinscher\n" +
                "Afghan hound\n" +
                "Airedale terrier\n" +
                "Akita\n" +
                "Alaskan Malamute\n" +
                "American Staffordshire terrier\n" +
                "American water spaniel\n" +
                "Australian cattle dog\n" +
                "Australian shepherd\n" +
                "Australian terrier\n" +
                "basenji\n" +
                "basset hound\n" +
                "beagle\n" +
                "bearded collieBedlington terrier\n" +
                "Bernese mountain dog\n" +
                "bichon frise\n" +
                "black and tan coonhound\n" +
                "bloodhound\n" +
                "border collie\n" +
                "border terrier\n" +
                "borzoi\n" +
                "Boston terrier\n" +
                "bouvier des Flandres\n" +
                "boxer\n" +
                "briard\n" +
                "Brittany\n" +
                "Brussels griffonbull terrier\n" +
                "bulldog\n" +
                "bullmastiff\n" +
                "cairn terrier\n" +
                "Canaan dog\n" +
                "Chesapeake Bay retriever\n" +
                "Chihuahua\n" +
                "Chinese crested\n" +
                "Chinese shar-pei\n" +
                "chow chow\n" +
                "Clumber spaniel\n" +
                "cocker spaniel\n" +
                "collie\n" +
                "curly-coated retriever\n" +
                "dachshund\n" +
                "Dalmatian\n" +
                "Doberman pinscherEnglish cocker spaniel\n" +
                "English setter\n" +
                "English springer spaniel\n" +
                "English toy spaniel\n" +
                "Eskimo dog\n" +
                "Finnish spitz\n" +
                "flat-coated retriever\n" +
                "fox terrier\n" +
                "foxhound\n" +
                "French bulldog\n" +
                "German shepherdGerman wirehaired pointer\n" +
                "golden retriever\n" +
                "Gordon setter\n" +
                "Great Dane\n" +
                "greyhound\n" +
                "Irish setter\n" +
                "Irish water spaniel\n" +
                "Irish wolfhound\n" +
                "Jack Russell terrier\n" +
                "Japanese spaniel\n" +
                "keeshond\n" +
                "Kerry blue terrier\n" +
                "komondor\n" +
                "kuvasz\n" +
                "Labrador retriever\nLakeland terrier\n" +
                "Lhasa apso\n" +
                "Maltese\n" +
                "Manchester terrier\n" +
                "mastiff\n" +
                "Mexican hairless\n" +
                "Newfoundland\n" +
                "Norwegian elkhound\n" +
                "Norwich terrier\n" +
                "otterhound\n" +
                "papillon\n" +
                "Pekingese\n" +
                "pointer\n" +
                "Pomeranian\n" +
                "poodle\n" +
                "pugpuli\n" +
                "Rhodesian ridgeback\n" +
                "Rottweiler\n" +
                "Saint Bernard\n" +
                "saluki\n" +
                "Samoyed\n" +
                "schipperke\n" +
                "schnauzer\n" +
                "Scottish deerhound\n" +
                "Scottish terrier\n" +
                "Sealyham terrier\n" +
                "Shetland sheepdog\n" +
                "shih tzu\n" +
                "Siberian husky\n" +
                "silky terrier\n" +
                "Skye terrier\n" +
                "Staffordshire bull terriersoft-coated wheaten terrier\n" +
                "Sussex spaniel\n" +
                "spitz\n" +
                "Tibetan terrier\n" +
                "vizsla\n" +
                "Weimaraner\n" +
                "Welsh terrier\n" +
                "West Highland white terrier\n" +
                "whippet\n" +
                "Yorkshire terrier"
               )

        var adapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)

        listView.adapter = adapter

        search.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                search.clearFocus()
                if (names.contains(query))
                {
                    adapter.filter.filter(query)
                }
                else{
                    Toast.makeText(applicationContext, "Breed not found", Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })


    }
}