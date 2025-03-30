# localnet_plugins_Permission
使localnet支持权限/权限组


# 注意
在插件第一次启动后，会创建config/permission目录，并包含空配置文件`users.yml`和`groups.yml`。
`users.yml`中必须存在`_default`用户，且权限不得为空（参考`example_users.yml`），否则任何对权限的请求都会出错。