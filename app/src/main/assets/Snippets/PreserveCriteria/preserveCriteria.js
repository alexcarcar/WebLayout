

/***
 * ====================================================================================================
 * TRELLIS_FORM -- TRE-16050: Saving Filtering Criteria
 *
 * Example:
 * var sForm = TRELLIS_FORM.toString("command"); // save
 * TRELLIS_FORM.toForm(sForm, "command"); // load
 * ====================================================================================================
 */
if (typeof TRELLIS_FORM === 'undefined') {

    var TRELLIS_FORM = {

        /***
         * toString -- Convert a form into a JSON string
         *
         * @param formId
         * @returns {string}
         */
        toString: function (formId) {
            var filledForm = jQuery("#" + formId);
            var formObject = {};
            var smartPopups = {};
            filledForm.find("input, select, textarea, hidden").each(function () {
                if (this.id === 'loadTimestamp') return; // do not preserve time stamp
                if (this.id) {
                    var elem = jQuery(this);
                    if (elem.attr("type") === 'checkbox' || elem.attr("type") === 'radio') {
                        formObject[this.id] = elem.attr("checked");
                    } else {
                        formObject[this.id] = elem.val();
                    }
                    if (this.parentElement.className === "smartPopup") {
                        smartPopups[this.parentElement.id] = 1;
                    }
                }
            });

            for (var sp in smartPopups) {
                var spObj = jQuery("#" + sp);
                var val = spObj.smarterPopup("getSelectedItemKeys");
                if (val.length !== 0) {
                    formObject[sp] = val;
                }
            }
            return JSON.stringify(formObject);
        },


        /***
         * toForm -- populate a form using a JSON string
         *
         * @param jsonString
         * @param formId
         */
        toForm: function (jsonString, formId) {
            if (typeof jsonString === 'undefined' || jsonString == null || jsonString === "") return;
            var unfilledForm = jQuery("#" + formId);
            var formObject = JSON.parse(jsonString);
            var smartPopups = {};
            unfilledForm.find("input, select, textarea, hidden").each(function () {
                if (this.id) {
                    id = this.id;
                    var elem = jQuery(this);
                    if (elem.attr("type") === "checkbox" || elem.attr("type") === "radio") {
                        elem.attr("checked", formObject[id]);
                    } else {
                        elem.val(formObject[id]);
                    }
                    if (this.parentElement.className === "smartPopup") {
                        smartPopups[this.parentElement.id] = 1;
                    }
                }
            });
            for (var sp in smartPopups) {
                var spValues = formObject[sp];
                if (typeof spValues !== 'undefined') {
                    var spObj = jQuery("#" + sp);
                    console.log(sp + "=" + spValues);
                    // TODO repopulate smarter popup
                    //spObj.smarterPopup("getSelectedItemKeys"));

                }
            }
        }
    };
}