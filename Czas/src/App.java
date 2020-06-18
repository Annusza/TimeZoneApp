import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import timezone.TimeZone;

public class App {

	public static void main(String[] args) {

		StringBuffer responseContent = new StringBuffer();
		BufferedReader reader;
		String line;
		String responseBody = null;

		Scanner scan = new Scanner(System.in);

		try {

			System.out.println("Wprowadz obszar:");
			String area = scan.nextLine();
			System.out.println("Wprowadz lokalizacjê:");
			String location = scan.nextLine();
			System.out.println(
					"Wprowadz region. Jeœli nie zamierzasz podawaæ regionu, zostaw puste pole i wciœnij ENTER:");
			String region = scan.nextLine();

			if (!area.isEmpty() && !location.isEmpty() && region.isEmpty()) {

				HttpURLConnection connection;

				URL u = new URL("http://worldtimeapi.org/api/timezone" + "/" + area + "/" + location);
				connection = (HttpURLConnection) u.openConnection();
				// System.out.println(hr.getResponseCode());

				connection.setRequestMethod("GET");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);

				int status = connection.getResponseCode();

				if (status == 200) {

					// System.out.println(status);

					reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

					while ((line = reader.readLine()) != null) {

						responseContent.append(line);

						System.out.println("Twoja strefa czasowa to:");
					}
					reader.close();

				} else if (status > 499) {

					reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

					while ((line = reader.readLine()) != null) {

						responseContent.append(line);
					}
					reader.close();

				} else {

					anotherConnection();
				}

				// System.out.println(responseContent.toString());
				convertJsonToObject(responseContent);
			} else if (!area.isEmpty() && !location.isEmpty() && !region.isEmpty()) {

				HttpURLConnection connection;

				URL u = new URL("http://worldtimeapi.org/api/timezone" + "/" + area + "/" + location + "/" + region);
				connection = (HttpURLConnection) u.openConnection();
				// System.out.println(hr.getResponseCode());

				connection.setRequestMethod("GET");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);

				int status = connection.getResponseCode();

				if (status == 200) {

					// System.out.println(status);

					reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

					while ((line = reader.readLine()) != null) {

						responseContent.append(line);
						System.out.println("Twója strefa czasowa to:");
					}
					reader.close();

				} else if (status == 404) {

					reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

					while ((line = reader.readLine()) != null) {

						responseContent.append(line);
					}
					reader.close();

				} else {

					anotherConnection();
				}

				// System.out.println(responseContent.toString());
				convertJsonToObject(responseContent);

			} else {

				anotherConnection();

			}
		} catch (Exception e) {

			System.out.println(e);
		}
	}

	private static void anotherConnection() {

		StringBuffer responseContent = new StringBuffer();
		BufferedReader reader;
		String line;
		String responseBody = null;
		HttpURLConnection connection;

		try {

			URL u = new URL("http://worldtimeapi.org/api/timezone");
			connection = (HttpURLConnection) u.openConnection();

			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			int status = connection.getResponseCode();

			if (status == 200) {

				System.out.println("Brak danych lub wpisano z³e wartoœci.");
				System.out.println("Wybierz w³aœciw¹ strefê czasow¹");

				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				while ((line = reader.readLine()) != null) {

					responseContent.append(line);
				}
				reader.close();

			}

			// System.out.println(responseContent.toString());
			convertJsonToObject(responseContent);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static void convertJsonToObject(StringBuffer stringBuffer) {

		String text = stringBuffer.toString();
		Gson gson = new Gson();
		TimeZone timeZoneFromJson = gson.fromJson(text, TimeZone.class);
		String textDateTime = timeZoneFromJson.getDatetime();
		String[] splitted = textDateTime.split("T");

		String time = splitted[1];

		System.out.println(time);
		// System.out.println(textDateTime);

	}

}
