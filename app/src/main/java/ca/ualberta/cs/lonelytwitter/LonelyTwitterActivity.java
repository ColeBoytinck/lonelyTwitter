package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author Cole Boytinck
 * @version 1.1
 * @see 1.0
 *
 * The main activity for the Lonely Twitter application
 *
 */

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file2.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> TweetList = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	/**
	 *
	 * @param savedInstanceState
	 *
	 * Called when the activity is first created
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		Firebase.setAndroidContext(this);
		final Firebase ref = new Firebase("https://fir-55ec5.firebaseio.com/");

		saveButton.setOnClickListener(new View.OnClickListener() {

			/**
			 *
			 * @param v View, the current view
			 *
			 * Sets the click activity for the save button
			 */
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet tweet = new Tweet(text);
				addTweet(tweet);
				Firebase tweetchild = ref.child("Tweets");
				tweetchild.setValue(TweetList);
				saveInFile();
				adapter.notifyDataSetChanged();

			}
		});

		ref.addValueEventListener(new ValueEventListener() {
									  public void onDataChange(DataSnapshot snapshot) {
									  	TweetList.clear();
									  	for (DataSnapshot d: snapshot.child("Tweets").getChildren()) {
									  		Tweet temp = d.getValue(Tweet.class);
									  		if(temp.getMessage().startsWith("\\L")) {
									  			temp.setMessage(temp.getMessage().toLowerCase());
											}
											if(temp.getMessage().startsWith("\\U")) {
												temp.setMessage(temp.getMessage().toUpperCase());
											}
											TweetList.add(temp);
										  }
									  }

									  public void onCancelled(FirebaseError firebaseError) {

									  }
								  });

				clearButton.setOnClickListener(new View.OnClickListener() {

					/**
					 * @param v View, the current view
					 *          <p>
					 *          Sets the click activity for the clear button
					 */
					public void onClick(View v) {
						setResult(RESULT_OK);

						TweetList.clear();

						//saveInFile(text, new Date(System.currentTimeMillis()));
						saveInFile();
						adapter.notifyDataSetChanged();
						//finish();

					}
				});
	}

	/**
	 * Called when the activity is started
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();

		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, TweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Loads the old tweets from a file
	 */
	public void loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();
			//Gson gson = new GsonBuilder().create();

			Type listType = new TypeToken<ArrayList<Tweet>>(){}.getType();

			TweetList = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return tweets.toArray(new String[tweets.size()]);
	}

	/**
	 * Saves all of the tweets in a file
	 */
	public void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			//Gson gson = new GsonBuilder().create();
			gson.toJson(TweetList, out);
			out.close();

			//fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int addTweet(Tweet tweet) {

		try {
			for(Tweet t: TweetList) {
				if(t.getMessage() == tweet.getMessage()) {
					throw new IllegalArgumentException();
				}
			}
		} catch(IllegalArgumentException e) {
			return -1;
		}

		TweetList.add(tweet);
		return 0;
	}

	public ArrayList<Tweet> getTweet() {
		return TweetList;
	}

	public boolean hasTweet(Tweet tweet) {
		for(Tweet t: TweetList) {
			if (t.getMessage() == tweet.getMessage()) {
				return true;
			}
		}
		return false;
	}

	public int getCount() {
		return TweetList.size();
	}
}