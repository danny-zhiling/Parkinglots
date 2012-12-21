停车场

1．构建停车场对象
    a)可以定义停车场的固有停车数
2．停车场停车
    a)空位数大于0时能正常停车。
    b)当停车场没有空位时不能再停车。
3．停车场取车
    a)车场为空时不能取车
    b)当停车场有车时，该辆车应能被取走。
    c)同一辆车不能被取走多次
4．停车场可用停车数显示
    a)取走一辆车时，空位数应加一。
    b)停入一辆车时，空位数减一，空位数不能小于0。

ParkingBoy

1．构建ParkingBoy对象
    a)可管理多个停车场  
2．ParkingBoy停车
    a)停车策略：顺序车场
    b)停车策略：最大可用数（空车率）
    c)车场全都满时不能停车，返回相应信息
3．ParkingBoy取车
    a)ParkingBoy应该有取车的功能
    b)当ParkingBoy要取得车不存在时，应取不到车并返回相应信息
    c)当停车场停满ParkingBoy再去停车时，应返回没有空车位信息  
4．产生车场状态报告
    a)可以汇总车场状态并产生停车场状态报告
    b)汇总所管车厂的所有停车数和可用停车数

ParkingManager

1．构建ParkingManager对象
    a)管理多个停车场
    b)可管理多个ParkingBoy
    c)指定ParkingBoy负责某个或某些停车场的功能
2．ParkingManager停车
    a)停车策略:可随机停车到所管的车场
    b)可以通过所管的ParkingBoy停车
3．ParkingManager取车
    a)可以自己取车
    b)可以通过所管的ParkingBoy取车
4．产生车场状态报告
    a)可以汇总ParkingBoy的车场状态并产生停车场状态报告
    b)汇总所管车厂的所有停车数和可用停车数

ParkingDirector

1．构建ParkingDirector对象
    a)管理多个停车场
    b)可管理多个ParkingManager对象
    c)指定ParkingManager负责某个或某些停车场的功能
2．查看获取停车场状态报告
    a)汇总ParkingManager所管理的车场状态报告
    b)汇总所管理的所有车场报告
