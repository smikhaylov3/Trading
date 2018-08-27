(function() {
  var getAxisMax, getAxisMin, getChartArray, getChartOptions, getPricesFromArray, populateStockHistory, updateStockChart;

  $(function() {
    var ws;
    ws = new WebSocket($("body").data("ws-url"));
    ws.onmessage = function(event) {
      var message;
      message = JSON.parse(event.data);
      switch (message.type) {
        case "stockhistory":
          return populateStockHistory(message);
        case "stockupdate":
          return updateStockChart(message);
        default:
          return console.log(message);
      }
    };
    return $("#addsymbolform").submit(function(event) {
      event.preventDefault();
      ws.send(JSON.stringify({
        symbol: $("#addsymboltext").val()
      }));
      return $("#addsymboltext").val("");
    });
  });

  getPricesFromArray = function(data) {
    var j, len, results, v;
    results = [];
    for (j = 0, len = data.length; j < len; j++) {
      v = data[j];
      results.push(v[1]);
    }
    return results;
  };

  getChartArray = function(data) {
    var i, j, len, results, v;
    results = [];
    for (i = j = 0, len = data.length; j < len; i = ++j) {
      v = data[i];
      results.push([i, v]);
    }
    return results;
  };

  getChartOptions = function(data) {
    return {
      series: {
        shadowSize: 0
      },
      yaxis: {
        min: getAxisMin(data),
        max: getAxisMax(data)
      },
      xaxis: {
        show: false
      }
    };
  };

  getAxisMin = function(data) {
    return Math.min.apply(Math, data) * 0.9;
  };

  getAxisMax = function(data) {
    return Math.max.apply(Math, data) * 1.1;
  };

  populateStockHistory = function(message) {
    var chart, chartHolder, detailsHolder, flipContainer, flipper, plot;
    chart = $("<div>").addClass("chart").prop("id", message.symbol);
    chartHolder = $("<div>").addClass("chart-holder").append(chart);
    chartHolder.append($("<p>").text("Values are from Yahoo Finance"));
    detailsHolder = $("<div>").addClass("details-holder");
    flipper = $("<div>").addClass("flipper").append(chartHolder).append(detailsHolder).attr("data-content", message.symbol);
    flipContainer = $("<div>").addClass("flip-container").append(flipper);
    $("#stocks").prepend(flipContainer);
    return plot = chart.plot([getChartArray(message.history)], getChartOptions(message.history)).data("plot");
  };

  updateStockChart = function(message) {
    var data, plot, yaxes;
    if ($("#" + message.symbol).size() > 0) {
      plot = $("#" + message.symbol).data("plot");
      data = getPricesFromArray(plot.getData()[0].data);
      data.shift();
      data.push(message.price);
      plot.setData([getChartArray(data)]);
      yaxes = plot.getOptions().yaxes[0];
      if ((getAxisMin(data) < yaxes.min) || (getAxisMax(data) > yaxes.max)) {
        yaxes.min = getAxisMin(data);
        yaxes.max = getAxisMax(data);
        plot.setupGrid();
      }
      return plot.draw();
    }
  };

}).call(this);

//# sourceMappingURL=index.js.map
