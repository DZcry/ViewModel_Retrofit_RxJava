package leavesc.hello.network;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import leavesc.hello.network.event.BaseActionEvent;
import leavesc.hello.network.model.Test;
import leavesc.hello.network.view.BaseActivity;
import leavesc.hello.network.viewmodel.FailExampleViewModel;
import leavesc.hello.network.viewmodel.TestExampleViewModel;
import leavesc.hello.network.viewmodel.base.LViewModelProviders;

public class TestlExampleActivity extends BaseActivity {

    private TestExampleViewModel failExampleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_example);
    }

    @Override
    protected ViewModel initViewModel() {
        failExampleViewModel = LViewModelProviders.of(this, TestExampleViewModel.class);
        failExampleViewModel.getTest1LiveData().observe(this, this::testReq);
        return failExampleViewModel;
    }

    public void test(View view) {
        failExampleViewModel.test("6046eab49b171e547480357c");
    }

    private void testReq(Test test) {
        Log.d("Test" , String.valueOf(test.getData().isIfVip()));
    }
}
