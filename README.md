# permissions-test
This sample application reclaims the **android.permission.ACCESS_FINE_LOCATION** permission, and then uses **PermissionChecker.checkSelfPermission** to verify the current permission status.

The value **PERMISSION_DENIED_APP_OP** is never returned.

1. Click on the application button calls to *ActivityCompat.requestPermissions*
2. The callback **onRequestPermissionsResult** is executed
3. Then the **PermissionChecker.checkSelfPermission** is executed and its return is printed on the textview
