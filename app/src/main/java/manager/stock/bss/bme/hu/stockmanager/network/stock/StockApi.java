package manager.stock.bss.bme.hu.stockmanager.network.stock;

import java.math.BigDecimal;

import manager.stock.bss.bme.hu.stockmanager.model.LoginRequest;
import manager.stock.bss.bme.hu.stockmanager.model.LoginSuccessResponse;
import manager.stock.bss.bme.hu.stockmanager.model.ToolListRequest;
import manager.stock.bss.bme.hu.stockmanager.model.ToolListResponse;
import manager.stock.bss.bme.hu.stockmanager.model.ToolRequest;
import manager.stock.bss.bme.hu.stockmanager.model.ToolResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface StockApi {
    /**
     *
     * Login attempt for syncing.
     * @param loginRequest
     * @return Call<LoginSuccessResponse>
     */

//    @Multipart
    @POST("login")
    Call<LoginSuccessResponse> loginPost(
            @Body LoginRequest loginRequest
    );


    /**
     *
     * Get tool
     * @param id id
     * @return Call<ToolResponse>
     */

    @GET("tool/{id}")
    Call<ToolResponse> toolIdGet(
            @Path("id") BigDecimal id
    );


    /**
     *
     * Update tool
     * @param toolList
     * @return Call<Void>
     */

    @PUT("tool/{id}")
    Call<Void> toolIdPut(
            @Body ToolRequest toolList
    );


    /**
     *
     * Add new tool
     * @param tool
     * @return Call<Void>
     */

    @POST("tool/{id}")
    Call<Void> toolIdPost(
            @Body ToolRequest tool
    );


    /**
     *
     * Delete tool
     * @param id
     * @return Call<Void>
     */

    @DELETE("tool/{id}")
    Call<Void> toolIdDelete(
            @Query("id") BigDecimal id
    );


    /**
     *
     * Get the list of tools.
     * @return Call<ToolListResponse>
     */

    @GET("tools")
    Call<ToolListResponse> toolsGet();



    /**
     * Update tool list.
     * Update tool list.
     * @param toolList
     * @return Call<Void>
     */

    @PUT("tools")
    Call<Void> toolsPut(
            @Body ToolListRequest toolList
    );

}
