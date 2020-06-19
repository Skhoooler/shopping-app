
package com.ebay.services.finding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 						Use findItemsIneBayStores to find items listed in eBay stores. Specify
 * 						storeName in the request to retrieve all listings within a single store. You
 * 						can combine storeName with keywords to find specific items, or use keywords
 * 						without storeName to search for items in all eBay stores.
 * 						<br><br>
 * 						Search results can be filtered by item details or aspects and sorted by a
 * 						variety of criteria.
 * 					
 * 
 * <p>Java class for FindItemsIneBayStoresRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FindItemsIneBayStoresRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ebay.com/marketplace/search/v1/services}BaseFindingServiceRequest">
 *       &lt;sequence>
 *         &lt;element name="keywords" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="storeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="itemFilter" type="{http://www.ebay.com/marketplace/search/v1/services}ItemFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="outputSelector" type="{http://www.ebay.com/marketplace/search/v1/services}OutputSelectorType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="aspectFilter" type="{http://www.ebay.com/marketplace/search/v1/services}AspectFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="domainFilter" type="{http://www.ebay.com/marketplace/search/v1/services}DomainFilter" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="categoryId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindItemsIneBayStoresRequest", propOrder = {
    "keywords",
    "storeName",
    "itemFilter",
    "outputSelector",
    "aspectFilter",
    "domainFilter",
    "categoryId"
})
public class FindItemsIneBayStoresRequest
    extends BaseFindingServiceRequest
    implements Serializable
{

    private final static long serialVersionUID = 12343L;
    protected String keywords;
    protected String storeName;
    protected List<ItemFilter> itemFilter;
    protected List<OutputSelectorType> outputSelector;
    protected List<AspectFilter> aspectFilter;
    protected List<DomainFilter> domainFilter;
    protected List<String> categoryId;

    /**
     * Gets the value of the keywords property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * Sets the value of the keywords property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeywords(String value) {
        this.keywords = value;
    }

    /**
     * Gets the value of the storeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Sets the value of the storeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoreName(String value) {
        this.storeName = value;
    }

    /**
     * Gets the value of the itemFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemFilter }
     * 
     * 
     */
    public List<ItemFilter> getItemFilter() {
        if (itemFilter == null) {
            itemFilter = new ArrayList<ItemFilter>();
        }
        return this.itemFilter;
    }

    /**
     * Gets the value of the outputSelector property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputSelector property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputSelector().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutputSelectorType }
     * 
     * 
     */
    public List<OutputSelectorType> getOutputSelector() {
        if (outputSelector == null) {
            outputSelector = new ArrayList<OutputSelectorType>();
        }
        return this.outputSelector;
    }

    /**
     * Gets the value of the aspectFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aspectFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAspectFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AspectFilter }
     * 
     * 
     */
    public List<AspectFilter> getAspectFilter() {
        if (aspectFilter == null) {
            aspectFilter = new ArrayList<AspectFilter>();
        }
        return this.aspectFilter;
    }

    /**
     * Gets the value of the domainFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the domainFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDomainFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DomainFilter }
     * 
     * 
     */
    public List<DomainFilter> getDomainFilter() {
        if (domainFilter == null) {
            domainFilter = new ArrayList<DomainFilter>();
        }
        return this.domainFilter;
    }

    /**
     * Gets the value of the categoryId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the categoryId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategoryId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCategoryId() {
        if (categoryId == null) {
            categoryId = new ArrayList<String>();
        }
        return this.categoryId;
    }

}
