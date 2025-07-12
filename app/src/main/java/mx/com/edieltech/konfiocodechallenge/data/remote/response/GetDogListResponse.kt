package mx.com.edieltech.konfiocodechallenge.data.remote.response

import com.google.gson.annotations.SerializedName

data class GetDogListResponse(
    @SerializedName("dogName"     ) var dogName     : String? = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("age"         ) var age         : Int?    = null,
    @SerializedName("image"       ) var image       : String? = null
)
