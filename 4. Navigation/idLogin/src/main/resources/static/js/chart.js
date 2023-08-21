// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Area Chart Example
var ctx = document.getElementById("myAreaChart");
var myLineChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: ["Mar 1", "Mar 2", "Mar 3", "Mar 4", "Mar 5", "Mar 6", "Mar 7", "Mar 8", "Mar 9", "Mar 10", "Mar 11", "Mar 12", "Mar 13"],
    datasets: [{
      label: "Sessions",
      lineTension: 0.3,
      backgroundColor: "rgba(2,117,216,0.2)",
      borderColor: "rgba(2,117,216,1)",
      pointRadius: 5,
      pointBackgroundColor: "rgba(2,117,216,1)",
      pointBorderColor: "rgba(255,255,255,0.8)",
      pointHoverRadius: 5,
      pointHoverBackgroundColor: "rgba(2,117,216,1)",
      pointHitRadius: 50,
      pointBorderWidth: 2,
      data: [10000, 30162, 26263, 18394, 18287, 28682, 31274, 33259, 25849, 24159, 32651, 31984, 38451],
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'date'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 7
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 40000,
          maxTicksLimit: 5
        },
        gridLines: {
          color: "rgba(0, 0, 0, .125)",
        }
      }],
    },
    legend: {
      display: false
    }
  }
});


// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Bar Chart Example
var ctx = document.getElementById("myBarChart");
var myLineChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ["January", "February", "March", "April", "May", "June"],
    datasets: [{
      label: "Revenue",
      backgroundColor: "rgba(2,117,216,1)",
      borderColor: "rgba(2,117,216,1)",
      data: [4215, 5312, 6251, 7841, 9821, 14984],
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 6
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 15000,
          maxTicksLimit: 5
        },
        gridLines: {
          display: true
        }
      }],
    },
    legend: {
      display: false
    }
  }
});


// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: ["Blue", "Red", "Yellow", "Green"],
    datasets: [{
      data: [12.21, 15.58, 11.25, 8.32],
      backgroundColor: ['#007bff', '#dc3545', '#ffc107', '#28a745'],
    }],
  },
});


// $.getJSON('https://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=52ac719bc95d0e3986c20c7769558d6f&units=metric', function(result) {
//   ('.ctemp').append(result.main.temp);
//   $('.lowtemp').append(result.main.temp_min);
//   $('.hightemp').append(result.main.temp_max);
//    result.weather[0].icon
//   var wiconUrl = '<img src="https://openweathermap.org/img/wn/' + result.weather[0].icon + '.png" alt="' + result.weather[0].description + '">'
//   $('.icon').html(wiconUrl);

//   createChart(result);
//   });


// function createChart(weatherData) {
//   var timeLabels = [];
//   var temperatureData = [];

//   for (var i = 0; i < 40; i++) {
//     var ctime = weatherData.list[i].dt;
//     var ctemp = weatherData.list[i].main.temp;
//     var currentTime = convertTime(ctime);

//     timeLabels.push(currentTime);
//     temperatureData.push(ctemp);
//   }

//   var ctx = document.getElementById('weatherChart').getContext('2d');
//   var weatherChart = new Chart(ctx, {
//     type: 'line',
//     data: {
//       labels: timeLabels,
//       datasets: [{
//         label: '온도 (°C)',
//         data: temperatureData,
//         borderColor: 'rgba(75, 192, 192, 1)',
//         backgroundColor: 'rgba(75, 192, 192, 0.2)',
//         borderWidth: 1,
//         fill: true
//       }]
//     },
//     options: {
//       scales: {
//         y: {
//           beginAtZero: true
//         }
//       }
//     }
//   });
// }
// function convertTime(t) {
//   var ot = new Date(t * 1000);
//   var datetime = ot.getDate();
//   var hour = ot.getHours();
//   return datetime + '일-' + hour + '시';
// }


$.getJSON('https://api.openweathermap.org/data/2.5/forecast?lat=37.5683&lon=126.9778&appid=52ac719bc95d0e3986c20c7769558d6f&units=metric', function(result) {

for(var i = 0; i < 40; i++) {
  var ctime = result.list[i].dt;
  var ctemp = result.list[i].main.temp; 
  var currentTime = convertTime(ctime);
  var tableHtml = '<tr>' + 
                    '<td>' + currentTime + '</td>' + 
                    '<td>' + ctemp + '</td>' + 
                  '</tr>';

  $('tbody').append(tableHtml);
}

function convertTime(t) {
  var ot = new Date(t * 1000); // ot = original time
  // Mon Jul 17 2023 16:31:23 GMT+0900 (한국 표준시)
  
  var datetime = ot.getDate();
  var hour = ot.getHours();

  return datetime + '일-' + hour + '시'
}

createChart(result.list);

});

function createChart(weatherData) {
// 그래프를 그릴 데이터 배열 생성
var timeLabels = [];
var temperatureData = [];

for (var i = 0; i < 40; i++) {
var ctime = weatherData[i].dt;
var ctemp = weatherData[i].main.temp;
var currentTime = convertTime(ctime);

timeLabels.push(currentTime);
temperatureData.push(ctemp);
}
var ctx = document.getElementById('weatherChart').getContext('2d');
var weatherChart = new Chart(ctx, {
type: 'line', // 선 그래프를 사용합니다.
data: {
  labels: timeLabels, // x축 레이블 (시간)
  datasets: [{
    label: 'Temperature (°C)',
    data: temperatureData, // y축 데이터 (온도)
    borderColor: 'rgba(75, 192, 192, 1)', // 선의 색상
    borderWidth: 2 // 선의 굵기
  }]
},
options: {
  responsive: false // 차트 크기를 조절하지 않도록 설정
}
});
}
function convertTime(t) {
var ot = new Date(t * 1000);
var datetime = ot.getDate();
var hour = ot.getHours();
return datetime + '일-' + hour + '시';
}


// 서버 API 엔드포인트 URL 정의

async function fetchTemperatureHumidityData() {
    try {
        const response = await fetch(apiUrl); // 여기서 apiUrl 사용
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error fetching data:', error);
        return [];
    }
}

