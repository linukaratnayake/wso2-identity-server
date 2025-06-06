/*
*Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*WSO2 Inc. licenses this file to you under the Apache License,
*Version 2.0 (the "License"); you may not use this file except
*in compliance with the License.
*You may obtain a copy of the License at
*
*http://www.apache.org/licenses/LICENSE-2.0
*
*Unless required by applicable law or agreed to in writing,
*software distributed under the License is distributed on an
*"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*KIND, either express or implied.  See the License for the
*specific language governing permissions and limitations
*under the License.
*/

package org.wso2.identity.integration.test.user.mgt;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class ReadWriteLDAPUserStoreManagerTestCase extends UserManagementServiceAbstractTest {

    // These attributes are not supported by the default LDAP schema.
    private static final Set<String> UNSUPPORTED_CLAIMS = new HashSet<>(Arrays.asList(
            "http://wso2.org/claims/emailAddresses",
            "http://wso2.org/claims/verifiedEmailAddresses",
            "http://wso2.org/claims/mobileNumbers",
            "http://wso2.org/claims/verifiedMobileNumbers"));

    @BeforeClass(alwaysRun = true)
    public void configureServer() throws Exception {
        super.doInit();

    }

    @AfterClass(alwaysRun = true)
    public void restoreServer() throws Exception {
        super.clean();
    }

    @Override
    protected void setUserName() {
        newUserName = "ReadWriteLDAPUserName" ;
    }

    @Override
    protected void setUserPassword() {
        newUserPassword = "ReadWriteLDAPUserName@123";
    }

    @Override
    protected void setUserRole() {
       newUserRole = "ReadWriteLDAPUserRole";
    }

    @Override
    protected Set<String> getExcludedClaims() {

        return UNSUPPORTED_CLAIMS;
    }
}

