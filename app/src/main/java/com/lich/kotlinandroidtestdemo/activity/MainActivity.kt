package com.lich.kotlinandroidtestdemo.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.DocumentsContract
import android.provider.DocumentsContract.Document
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.documentfile.provider.DocumentFile
import com.lich.kotlinandroidtestdemo.R
import net.i2p.crypto.eddsa.KeyPairGenerator
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.security.SecureRandom
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var toast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            if (data != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val uri = data.data
                val docUri = DocumentsContract.buildDocumentUriUsingTree(
                    uri,
                    DocumentsContract.getTreeDocumentId(uri)
                )

                val cursor = contentResolver.query(
                    docUri, arrayOf(
                        DocumentsContract.Document.COLUMN_DISPLAY_NAME,
                        DocumentsContract.Document.COLUMN_MIME_TYPE
                    ), null, null, null
                )

                val newUri = DocumentsContract.createDocument(
                    contentResolver,
                    docUri,
                    Document.MIME_TYPE_DIR,
                    "abc"
                )

                DocumentFile

                val ins = contentResolver.openInputStream(docUri)
                ins.


            }
        }
    }

    fun saveFile(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            startActivityForResult(intent, 0)
        }
    }

//    fun updateDirectoryEntries(uri: Uri) {
//        val contentResolver: ContentResolver = getActivity().getContentResolver()
//        val docUri: Uri = DocumentsContract.buildDocumentUriUsingTree(
//            uri,
//            DocumentsContract.getTreeDocumentId(uri)
//        )
//        val childrenUri: Uri = DocumentsContract.buildChildDocumentsUriUsingTree(
//            uri,
//            DocumentsContract.getTreeDocumentId(uri)
//        )
//        val docCursor: Cursor? = contentResolver.query(
//            docUri, arrayOf(
//                Document.COLUMN_DISPLAY_NAME, Document.COLUMN_MIME_TYPE
//            ), null, null, null
//        )
//        try {
//            while (docCursor.moveToNext()) {
//                Log.d(
//                    TAG, "found doc =" + docCursor.getString(0).toString() + ", mime=" + docCursor
//                        .getString(1)
//                )
//                mCurrentDirectoryUri = uri
//                mCurrentDirectoryTextView.setText(docCursor.getString(0))
//                mCreateDirectoryButton.setEnabled(true)
//            }
//        } finally {
//            closeQuietly(docCursor)
//        }
//        val childCursor: Cursor? = contentResolver.query(
//            childrenUri, arrayOf(
//                Document.COLUMN_DISPLAY_NAME, Document.COLUMN_MIME_TYPE
//            ), null, null, null
//        )
//        try {
//            val directoryEntries: MutableList<DirectoryEntry> = ArrayList()
//            while (childCursor.moveToNext()) {
//                Log.d(
//                    TAG,
//                    "found child=" + childCursor.getString(0).toString() + ", mime=" + childCursor
//                        .getString(1)
//                )
//                val entry = DirectoryEntry()
//                entry.fileName = childCursor.getString(0)
//                entry.mimeType = childCursor.getString(1)
//                directoryEntries.add(entry)
//            }
//            mAdapter.setDirectoryEntries(directoryEntries)
//            mAdapter.notifyDataSetChanged()
//        } finally {
//            closeQuietly(childCursor)
//        }
//    }

    fun generateKey(view: View) {

        var str = "helloworldhelloworldhelloworld11"
        val bytes = str.toByteArray()

        val generator = KeyPairGenerator()
        generator.initialize(256, SecureRandom(bytes))
        val pair = generator.generateKeyPair()

        val pri = pair.private.encoded
        val pub = pair.public.encoded

        val priString = Base64.encodeToString(pri, Base64.DEFAULT)
        val pubString = Base64.encodeToString(pub, Base64.DEFAULT)

        val a = ""

        Log.e("howgerprivate", priString)
        Log.e("howgerprivate", "" + priString.length)
        Log.e("howgerpub", pubString)
        Log.e("howgerpub", "" + pubString.length)
    }

    fun openFile(view: View) {
//        val intent = Intent()
//        intent.action = Intent.ACTION_GET_CONTENT
//        intent.type = "*/*"
//        startActivityForResult(intent, 0)

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            val i = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
//            i.addCategory(Intent.CATEGORY_DEFAULT)
//            startActivityForResult(Intent.createChooser(i, ""), 9999)
//        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            startActivityForResult(intent, 0)
        }

//        val intent = Intent(Intent.documen)
//        intent.type = "file/*"
//        startActivityForResult(intent, 0)
    }

    fun test01(view: View) {
        val name = "_head_" + Date().time
        val path = getExternalFilesDir(null).toString() + name + ".txt"
        val file = File(path)

        val string = "fjkdjfklsdjflksdjfskdjfkdjfkdaaaaaaaaaaaaaaaaaaaaaaaaaaaa"

        val writer = BufferedWriter(FileWriter(file))
        writer.write(string)
        writer.flush()
        writer.close()

    }

    fun test02(view: View) {
        startActivity(Intent(this, TestActivity2::class.java))
        overridePendingTransition(R.anim.anim_activity_out, R.anim.anim_activity_in)
    }

    fun test03(view: View) {
        startActivity(Intent(this, TestActivity3::class.java))
    }

    fun test04(view: View) {
        startActivity(Intent(this, TestActivity4::class.java))
    }

}


