package com.aravind.smb

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FileListModel {

    @SerializedName("Filelist")
    @Expose
     var filelist : MutableList<FileContentInfo> ? = null

    inner class FileContentInfo{
        @SerializedName("Filename")
        @Expose
        var Filename : String? = null

        @SerializedName("Filetype")
        @Expose
         var Filetype : String? = null

        @SerializedName("StorageType")
        @Expose
         var StorageType : String? = null

        @SerializedName("StorageLocation")
        @Expose
         var StorageLocation : String? = null

        @SerializedName("FileSize")
        @Expose
         var FileSize : Int = 0

        @SerializedName("LastSyncupTime")
        @Expose
        var LastSyncupTime : String? = null
    }
}