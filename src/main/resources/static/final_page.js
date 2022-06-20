fetch("writeData.json").then((data)=>{
    return data.json();
  }).then((obj)=>{
     console.log(obj);
       let tableData="";
       var values=obj;
       //const str = JSON.stringify(obj, undefined, 2);
       for( i=0;i<values.length;i++){ 
         var object = JSON.parse(JSON.stringify(values[i]));
           if(object!="null"){
             tableData+=
             ` <tr>
                 <td>${object["Installment No."]}</td>
                 <td>${object["Stage Number"]}</td>
                 <td>${object["Installment Due Date"]}</td>
                 <td>${object["Installment Amount"]}</td>
                 <td>${object["Interest Rate"]}</td>
                 <td>${object["Component 1 (Principal)"]}</td>
                 <td>${object["Component 2 (Interest)"]}</td>
               <!--  <td>${object["Component 3 (Fees)"]}</td>
                 <td>${object["Component 4 (Insurance Premium)"]}</td> -->
                 <td>${object["Opening Balance"]}</td>
                 <td>${object["Closing Balance"]}</td>
             </tr>`;
           }
       }
       document.getElementById("table_body").
       innerHTML=tableData;
  })

