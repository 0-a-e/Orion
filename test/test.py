import asyncio
from bleak import BleakScanner, BleakClient
import struct
import logging

# 設定
MAC_ADDRESS = "EA:4A:78:6E:89:8D"
SERVICE_UUID = "16671501-e783-4330-b308-b9e1481ecfcc"
CHARACTERISTIC_UUID = "16671502-e783-4330-b308-b9e1481ecfcc"

def parse_reon_data(data):
    """REONのBLEデータを解析"""
    if len(data) < 9:
        return None
    
    temperature = struct.unpack('<f', data[0:4])[0]
    humidity = struct.unpack('<f', data[4:8])[0]
    battery = data[8]
    
    return {
        "temperature": round(temperature, 1),
        "humidity": round(humidity, 1),
        "battery": battery
    }

async def connect_and_read():
    # デバイスをスキャン
    scanner = BleakScanner()
    await scanner.start()
    await asyncio.sleep(5)  # 5秒間スキャン
    await scanner.stop()

    # 対象デバイスをフィルタ
    device = next((d for d in scanner.discovered_devices if d.address == MAC_ADDRESS), None)
    if not device:
        print("REON Pocket Tag not found!")
        return

    # 接続してデータを一度だけ読み取り
    async with BleakClient(device) as client:
        print(f"Connected: {client.is_connected}")
        
        # サービスとキャラクタリスティックを確認
        try:
            # キャラクタリスティックから一度だけデータを読み取り
            data = await client.read_gatt_char(CHARACTERISTIC_UUID)
            parsed = parse_reon_data(data)
            if parsed:
                print(f"Temperature: {parsed['temperature']}°C")
                print(f"Humidity: {parsed['humidity']}%")
                print(f"Battery: {parsed['battery']}%")
        except Exception as e:
            print(f"Error reading characteristic: {e}")

asyncio.run(connect_and_read())