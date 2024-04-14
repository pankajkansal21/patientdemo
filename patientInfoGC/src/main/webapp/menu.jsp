<!DOCTYPE html>
<html>
<head>
    <style>
        .menu-ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #333;
        }

        .menu-li {
            float: left;
            border-right:1px solid #bbb;
        }

        .menu-li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .menu-li a:hover:not(.active) {
            background-color: #111;
        }


    </style>
</head>
<body>

<ul class="menu-ul">
    <li class="menu-li"><a href="/patient/showAddPatient.action">Add Patient</a></li>
    <li class="menu-li"><a href="/patient/showSearchPatient.action">View Patients</a></li>
    <li class="menu-li"><a href="/patient/showAddMedicine.action">Add Medicine</a></li>
    <li class="menu-li"><a href="/patient/viewMedicines.action">View Medicines</a></li>
    <li class="menu-li" style="float:right"><a href="/patient/logout.action">Logout</a></li>
</ul>


</body>
</html>


