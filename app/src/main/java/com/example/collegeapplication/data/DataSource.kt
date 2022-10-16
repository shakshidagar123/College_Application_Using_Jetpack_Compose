package com.example.collegeapplication.data

import com.example.collegeapplication.R
import com.example.collegeapplication.ui.Departments
import com.example.collegeapplication.ui.Society

class DataSource {

        fun loadDepartments(): List<Departments> {
            return listOf<Departments>(
                Departments(R.string.Computer, R.drawable.comp),
                Departments(R.string.Physics, R.drawable.phy),
                Departments(R.string.Mathematics, R.drawable.math),
                Departments(R.string.Economics, R.drawable.eco),
                Departments(R.string.Botany, R.drawable.bot),
                Departments(R.string.Chemistry, R.drawable.chem),
                Departments(R.string.history_dept,R.drawable.history),
                Departments(R.string.pol_sci,R.drawable.polscience_2_1)

            )
        }
    fun loadSociety(): List<Society> {
        return listOf<Society>(
            Society(R.string.ncc,R.drawable.ncc,R.string.nccmh),
            Society(R.string.nss,R.drawable.nss,R.string.nssmh),
            Society(R.string.Tanz,R.drawable.tanz,R.string.Tanzmh),
            Society(R.string.ecell,R.drawable.ecell,R.string.ecellmh),
            Society(R.string.enactus,R.drawable.enactus,R.string.enactusmh),
            Society(R.string.mh_vatavaran,R.drawable.vantavaran, R.string.mhvatavaran)
        )
    }

}