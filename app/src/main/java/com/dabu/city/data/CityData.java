package com.dabu.city.data;

import com.dabu.city.model.CityItem;
import com.dabu.city.widget.ContactItemInterface;
import com.dabu.city.widget.pinyin.PinYin;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * 357个中国城市
 * @author ck
 * @since 2014年2月7日 16:20:32
 */
public class CityData
{
	static String cityJson = "{'cities':[ '上海','北京','杭州','广州','南京','苏州','深圳','成都','重庆','天津','宁波','扬州','无锡','福州','厦门','武汉','西安','沈阳','大连','青岛','济南','海口','石家庄','唐山','秦皇岛','邯郸','邢台','保定','张家口','承德','沧州','廊坊','衡水','太原','大同','阳泉','长治','晋城','朔州','晋中','运城','包头','哈尔滨','齐齐哈尔','常州','南通','连云港','淮安','盐城','温州','嘉兴','湖州','绍兴','金华','衢州','舟山','台州','丽水','合肥','芜湖','蚌埠','淮南','马鞍山','宜昌','襄阳','鄂州','荆门','株洲','湘潭','衡阳','邵阳','岳阳','常德','张家界','益阳','郴州','永州','怀化','娄底','湘西','韶关','珠海','汕头','佛山','江门','湛江','茂名','肇庆','惠州','梅州','汕尾','河源','阳江','清远','东莞','中山','潮州','揭阳','南宁','桂林','梧州','北海','宜宾','广安','达州','雅安','巴中','资阳','阿坝','甘孜州','凉山','贵阳','六盘水','遵义','安顺','铜仁地区','黔西南','毕节地区','海西','银川','克孜勒苏','喀什地区','和田地区','伊犁','塔城地区','阿勒泰地区','石河子','香港','澳门','长沙','三亚']}";

	public static List<ContactItemInterface> getSampleContactList()
	{
		List<ContactItemInterface> list = new ArrayList<ContactItemInterface>();

		try
		{
			JSONObject jo1 = new JSONObject(cityJson);

			JSONArray ja1 = jo1.getJSONArray("cities");

			for(int i = 0; i < ja1.length(); i++)
			{
				String cityName = ja1.getString(i);

				list.add(new CityItem(cityName, PinYin.getPinYin(cityName)));
			}
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}

		return list;
	}

}
