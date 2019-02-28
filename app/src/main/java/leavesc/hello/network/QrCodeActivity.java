package leavesc.hello.network;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import leavesc.hello.library.viewmodel.LViewModelProviders;
import leavesc.hello.network.model.QrCode;
import leavesc.hello.library.view.BaseActivity;
import leavesc.hello.network.viewmodel.QrCodeViewModel;

/**
 * 作者：leavesC
 * 时间：2018/10/29 21:24
 * 描述：
 * GitHub：https://github.com/leavesC
 * Blog：https://www.jianshu.com/u/9df45b87cfdf
 */
public class QrCodeActivity extends BaseActivity {

    private EditText et_text;

    private ImageView iv_qrCode;

    private QrCodeViewModel qrCodeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        et_text = findViewById(R.id.et_text);
        iv_qrCode = findViewById(R.id.iv_qrCode);
    }

    @Override
    protected ViewModel initViewModel() {
        qrCodeViewModel = LViewModelProviders.of(this, QrCodeViewModel.class);
        qrCodeViewModel.getQrCodeLiveData().observe(this, this::handleQrCode);
        return qrCodeViewModel;
    }

    private void handleQrCode(QrCode qrCode) {
        iv_qrCode.setImageBitmap(qrCode.getBitmap());
    }

    public void createQrCode(View view) {
        iv_qrCode.setImageBitmap(null);
        qrCodeViewModel.createQrCode(et_text.getText().toString(), 600);
    }

}