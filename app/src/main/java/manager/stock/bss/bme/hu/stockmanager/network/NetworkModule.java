package manager.stock.bss.bme.hu.stockmanager.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import manager.stock.bss.bme.hu.stockmanager.network.stock.StockApi;
import manager.stock.bss.bme.hu.stockmanager.util.GsonHelper;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public StockApi provideATodoApi(Retrofit retrofit) {
        return retrofit.create(StockApi.class);
    }


}