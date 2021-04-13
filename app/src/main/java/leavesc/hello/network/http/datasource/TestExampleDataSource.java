package leavesc.hello.network.http.datasource;

import leavesc.hello.network.http.basis.BaseRemoteDataSource;
import leavesc.hello.network.http.basis.callback.RequestCallback;
import leavesc.hello.network.http.basis.config.HttpConfig;
import leavesc.hello.network.http.datasource.base.IFailExampleDataSource;
import leavesc.hello.network.http.datasource.base.ITestExampleDataSource;
import leavesc.hello.network.http.service.ApiService;
import leavesc.hello.network.model.Test;
import leavesc.hello.network.viewmodel.base.BaseViewModel;

public class TestExampleDataSource extends BaseRemoteDataSource implements ITestExampleDataSource {

    public TestExampleDataSource(BaseViewModel baseViewModel) {
        super(baseViewModel);
    }

    @Override
    public void test(String id, RequestCallback<Test> callback) {
        execute(getService(ApiService.class, HttpConfig.BASE_URL).test3(id), callback);
    }

}