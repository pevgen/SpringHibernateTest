package test.ml.pevgen.test.springhibernate.utils;

import ml.pevgen.test.springhibernate.utils.XmlFieldReader;
import ml.pevgen.test.springhibernate.xmlmodel.XmlCustomLayout;
import org.hamcrest.Matchers;
import org.hamcrest.text.IsEmptyString;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.*;


/**
 * XmlFieldReader Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>��� 19, 2016</pre>
 */
public class XmlFieldReaderTest {

    @Test
    public void testReadAnyXml() throws Exception {
        Object result = XmlFieldReader.readXml(XML_LAYOUT_1, Object.class);
        Assert.assertThat(result, notNullValue());
    }

    @Test
    public void testReadCustomLayoutXml() throws Exception {
        XmlCustomLayout result = XmlFieldReader.readXml(XML_LAYOUT_1, XmlCustomLayout.class);
        Assert.assertThat(result, notNullValue());
    }


    @Test
    public void testWriteXml() throws IOException {
        XmlCustomLayout customLayout = new XmlCustomLayout();
        String result = XmlFieldReader.writeXml(customLayout);
        Assert.assertThat(result, notNullValue());
        Assert.assertThat(result, not(IsEmptyString.isEmptyString()));
    }

    private String XML_LAYOUT_1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<Customization xmlns=\"http://www.transsys.ru/phoenix/modules.contactchart.internal/primary\">\n" +
            "  <Parameters>\n" +
            "    <Parameter name=\"ContactChartPastHours\" value=\"24\"/>\n" +
            "    <Parameter name=\"ContactChartFutureHours\" value=\"14\"/>\n" +
            "    <Parameter name=\"FontSize\" value=\"10pt\"/>\n" +
            "    <Parameter name=\"PixelsPerHour\" value=\"48\"/>\n" +
            "    <!--Parameter name=\"ContactChartOverridenNow\" value=\"24.10.2011 10:38:00\"/--> \n" +
            "    <Parameter name=\"AutoRefreshPeriod\" value=\"900\"/>   \n" +
            "  </Parameters>\n" +
            "  <Preferences/>\n" +
            "  <Layout>\n" +
            "    <LayoutItem objectId=\"91000062200001\" kind=\"Approach\"/>    \n" +
            "   <LayoutItem title=\"01 ПП\" kind=\"WorkChart\" supplementSet=\"treeitem\">\n" +
            "   <LayoutItem objectId=\"91000010100101\"/> \n" +
            "   <LayoutItem objectId=\"91000010100102\"/> \n" +
            "   <LayoutItem objectId=\"91000010100103\"/> \n" +
            "   <LayoutItem objectId=\"91000010100104\"/> \n" +
            "   <LayoutItem objectId=\"91000010100105\"/> \n" +
            "   <LayoutItem objectId=\"91000010100106\"/> \n" +
            "   <LayoutItem objectId=\"91000010100107\"/> \n" +
            "   <LayoutItem objectId=\"91000010100108\"/> \n" +
            "   <LayoutItem objectId=\"91000010100109\"/> \n" +
            "   <LayoutItem objectId=\"91000010100110\"/> \n" +
            "   <LayoutItem objectId=\"91000010100113\"/> \n" +
            "   <LayoutItem objectId=\"91000010100118\"/> \n" +
            "   </LayoutItem>\n" +
            "   <LayoutItem title=\"03 СП\" kind=\"WorkChart\" supplementSet=\"treeitem\">    \n" +
            "   <LayoutItem objectId=\"91000010100318\"/> \n" +
            "   <LayoutItem objectId=\"91000010100331\"/> \n" +
            "   <LayoutItem objectId=\"91000010100332\"/> \n" +
            "   <LayoutItem objectId=\"91000010100333\"/> \n" +
            "   <LayoutItem objectId=\"91000010100335\"/> \n" +
            "   <LayoutItem objectId=\"91000010100336\"/> \n" +
            "   <LayoutItem objectId=\"91000010100337\"/> \n" +
            "   <LayoutItem objectId=\"91000010100341\"/> \n" +
            "   <LayoutItem objectId=\"91000010100342\"/> \n" +
            "   <LayoutItem objectId=\"91000010100343\"/> \n" +
            "   <LayoutItem objectId=\"91000010100344\"/> \n" +
            "   <LayoutItem objectId=\"91000010100345\"/> \n" +
            "   <LayoutItem objectId=\"91000010100347\"/> \n" +
            "   <LayoutItem objectId=\"91000010100348\"/> \n" +
            "   <LayoutItem objectId=\"91000010100349\"/> \n" +
            "   <LayoutItem objectId=\"91000010100352\"/> \n" +
            "   <LayoutItem objectId=\"91000010100353\"/> \n" +
            "   </LayoutItem>\n" +
            "   <LayoutItem title=\"05 ПОП\" kind=\"WorkChart\" supplementSet=\"treeitem\">\n" +
            "   <LayoutItem objectId=\"91000010100501\"/> \n" +
            "   <LayoutItem objectId=\"91000010100502\"/> \n" +
            "   <LayoutItem objectId=\"91000010100503\"/> \n" +
            "   <LayoutItem objectId=\"91000010100504\"/> \n" +
            "   <LayoutItem objectId=\"91000010100505\"/> \n" +
            "   <LayoutItem objectId=\"91000010100506\"/> \n" +
            "   <LayoutItem objectId=\"91000010100507\"/> \n" +
            "   <LayoutItem objectId=\"91000010100508\"/> \n" +
            "   <LayoutItem objectId=\"91000010100509\"/> \n" +
            "   <LayoutItem objectId=\"91000010100510\"/> \n" +
            "   <LayoutItem objectId=\"91000010100511\"/> \n" +
            "   <LayoutItem objectId=\"91000010100512\"/> \n" +
            "   <LayoutItem objectId=\"91000010100513\"/> \n" +
            "   <LayoutItem objectId=\"91000010100514\"/> \n" +
            "   <LayoutItem objectId=\"91000010100515\"/> \n" +
            "   <LayoutItem objectId=\"91000010100516\"/> \n" +
            "   <LayoutItem objectId=\"91000010100517\"/> \n" +
            "   <LayoutItem objectId=\"91000010100523\"/> \n" +
            "   <LayoutItem objectId=\"91000010100524\"/> \n" +
            "   <LayoutItem objectId=\"91000010100550\"/> \n" +
            "   </LayoutItem>\n" +
            "   <LayoutItem title=\"07 УБОРКА\" kind=\"WorkChart\" supplementSet=\"treeitem\">\n" +
            "   <LayoutItem objectId=\"91000010100701\"/> \n" +
            "   <LayoutItem objectId=\"91000010100726\"/> \n" +
            "   <LayoutItem objectId=\"91000010100702\"/> \n" +
            "   <LayoutItem objectId=\"91000010100727\"/> \n" +
            "   <LayoutItem objectId=\"91000010100728\"/> \n" +
            "   <LayoutItem objectId=\"91000010100703\"/> \n" +
            "   <LayoutItem objectId=\"91000010100704\"/> \n" +
            "   <LayoutItem objectId=\"91000010100729\"/> \n" +
            "   <LayoutItem objectId=\"91000010100730\"/> \n" +
            "   <LayoutItem objectId=\"91000010100705\"/> \n" +
            "   <LayoutItem objectId=\"91000010100706\"/> \n" +
            "   <LayoutItem objectId=\"91000010100731\"/> \n" +
            "   <LayoutItem objectId=\"91000010100732\"/> \n" +
            "   <LayoutItem objectId=\"91000010100707\"/> \n" +
            "   <LayoutItem objectId=\"91000010100708\"/> \n" +
            "   <LayoutItem objectId=\"91000010100733\"/> \n" +
            "   <LayoutItem objectId=\"91000010100709\"/> \n" +
            "   <LayoutItem objectId=\"91000010100736\"/> \n" +
            "   <LayoutItem objectId=\"91000010100710\"/> \n" +
            "   <LayoutItem objectId=\"91000010100737\"/> \n" +
            "   <LayoutItem objectId=\"91000010100738\"/>    \n" +
            "     <LayoutItem objectId=\"91000010100739\"/>    \n" +
            "     <LayoutItem objectId=\"91000010100741\"/>    \n" +
            "     <LayoutItem objectId=\"91000010100742\"/>    \n" +
            "     <LayoutItem objectId=\"91000010100743\"/>    \n" +
            "     <LayoutItem objectId=\"91000010100744\"/>    \n" +
            "     <LayoutItem objectId=\"91000010100747\"/>    \n" +
            "     <LayoutItem objectId=\"91000010100748\"/>    \n" +
            "     <LayoutItem objectId=\"91000010100754\"/>    \n" +
            "     <LayoutItem objectId=\"91000010100755\"/>    \n" +
            "     <LayoutItem objectId=\"91000010100756\"/>    \n" +
            "   </LayoutItem>\n" +
            "   <LayoutItem objectId=\"91000062200002\" kind=\"Approach\"/>\n" +
            "  </Layout>\n" +
            "</Customization>";

}
