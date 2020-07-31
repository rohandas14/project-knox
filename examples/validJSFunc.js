function main(params) {
    var accounts = params.accounts;
    var transactions = accounts[0].transactions;
    var totalBalance = 0;
    var noOfTxn = transactions.length;
    for (i = 0; i < noOfTxn; i++) {
        totalBalance += parseFloat(transactions[i].CurrentBalance);
    }
    var avgBalance = totalBalance / noOfTxn;
    var result = avgBalance > 50000;
    return {
        greaterThan50K: result
    };
}

//Sample data request in data.json file.