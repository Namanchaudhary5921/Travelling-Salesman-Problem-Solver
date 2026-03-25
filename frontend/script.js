function parseCoordinates(input) {
    let lines = input.trim().split("\n");
    let coords = [];

    for (let line of lines) {
        let parts = line.split(",");
        if (parts.length !== 2) continue;
        let x = parseInt(parts[0].trim());
        let y = parseInt(parts[1].trim());
        if (isNaN(x) || isNaN(y)) continue;
        coords.push([x, y]);
    }

    return coords;
}

function solve() {
    let input = document.getElementById("coords").value;
    let algorithm = document.getElementById("algo").value;

    let coordinates = parseCoordinates(input);

    if (coordinates.length < 2) {
        alert("Enter at least 2 valid coordinates!");
        return;
    }

    fetch("https://zany-couscous-q7xvpq569r5p3jvp-8080.app.github.dev/tsp/solve", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ coordinates: coordinates, algorithm: algorithm })
    })
    .then(res => res.json())
    .then(data => {
        document.getElementById("result").innerText =
            "Cost: " + data.cost + "\nPath: " + data.path.join(" -> ");
    })
    .catch(err => {
        console.error(err);
        alert("Error connecting to backend");
    });
}