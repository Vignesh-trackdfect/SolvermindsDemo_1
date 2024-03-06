            $(document).ready(function(){
                var s1 = [1,0,0,0,0,1,0,1,1,1];
                var s2 = [0,1,1,1,1,0,1,0,0,0];
                var s3 = [0,0,0,0,0,0,0,0,0,0];

var ticks = [42,43,44,45,46,47,48,49,50,51];    $.jqplot('bar', [s1, s2, s3], {
        animate: true,axesDefaults:{min:0,tickInterval: 1},        seriesColors: ["#7BB661", "#E03C31", "#21ABCD"],
        stackSeries: false,
        seriesDefaults: {
            renderer: $.jqplot.BarRenderer,
            pointLabels: {show: true}
            , rendererOptions: {barWidth: 12, barMargin: 25, fillToZero: true}
        }
        ,
        grid: {borderColor: '#ffffff', background: '#ffffff',
            borderWidth: 0.5, // pixel width of border around grid.
            shadow: false // draw a shadow for grid.
        }
        ,
        legend: {
            show: true,
            location: 'e',
            placement: 'outside',
            labels: ['Passed', 'Failed', 'Skipped']
        },
        axes: {
            xaxis: {
                renderer: $.jqplot.CategoryAxisRenderer,
                ticks: ticks,
                label: "Test Iterations <font size = 1> <i> (The graph illustrates last 10 executions) </i> </font>"
            }
            ,
            yaxis: {
                label: "No.of Test Cases",
                tickOptions: {
                    formatString: "%d"
                }
            }
        }
    });
});
