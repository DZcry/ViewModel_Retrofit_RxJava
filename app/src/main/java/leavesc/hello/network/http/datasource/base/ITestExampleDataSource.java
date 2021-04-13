package leavesc.hello.network.http.datasource.base;

import leavesc.hello.network.http.basis.callback.RequestCallback;
import leavesc.hello.network.model.Test;

public interface ITestExampleDataSource {

    void test(String id, RequestCallback<Test> callback);

}
