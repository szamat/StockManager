package manager.stock.bss.bme.hu.stockmanager.mock.intercptors;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;

import manager.stock.bss.bme.hu.stockmanager.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static manager.stock.bss.bme.hu.stockmanager.mock.intercptors.MockHelper.makeResponse;


public class MockInterceptor implements Interceptor {

	@Override
	public Response intercept(Chain chain) throws IOException {
		return process(chain.request());
	}

	public Response process(Request request) {

		Uri uri = Uri.parse(request.url().toString());

		Log.d("Test Http Client", "URL call: " + uri.toString());
		Headers headers = request.headers();

		return StockMock.process(request);
	}

}
