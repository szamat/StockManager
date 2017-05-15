package manager.stock.bss.bme.hu.stockmanager.mock.intercptors;

import android.net.Uri;
import android.util.StringBuilderPrinter;

import manager.stock.bss.bme.hu.stockmanager.model.LoginSuccessResponse;
import manager.stock.bss.bme.hu.stockmanager.network.NetworkConfig;
import manager.stock.bss.bme.hu.stockmanager.util.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static manager.stock.bss.bme.hu.stockmanager.mock.intercptors.MockHelper.makeResponse;

public class StockMock {
	public static Response process(Request request) {
		Uri uri = Uri.parse(request.url().toString());

		String responseString;
		int responseCode;
		Headers headers = request.headers();

		if (request.url().toString().endsWith(NetworkConfig.ENDPOINT_PREFIX + "todo/favourite") && request.method().equals("POST")) {
//			request.body()
			responseString = "";
			responseCode = 200;
            /*
		}else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Todos") && request.method().equals("Get")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			responseString = GsonHelper.getGson().toJson(memoryRepository.getFavourites());
			responseCode = 200;*/
		} else if(request.url().toString().endsWith(NetworkConfig.ENDPOINT_PREFIX + "login") && request.method().equals("POST")) {
			LoginSuccessResponse loginSuccessResponse = new LoginSuccessResponse();
			loginSuccessResponse.setUsername("admin");
            loginSuccessResponse.setGetToolsUri("getToolURI");
			responseString = GsonHelper.getGson().toJson(loginSuccessResponse);
            responseCode = 200;
           /* } else {
                responseCode = 401;
            }*/
        } else if(request.url().toString().endsWith(NetworkConfig.ENDPOINT_PREFIX + "tools") && request.method().equals("PUT")) {
            responseCode = 200;
            responseString = "";
		} else {
            responseString = "ERROR";
            responseCode = 503;
        }

		return makeResponse(request, headers, responseCode, responseString);
	}
}
