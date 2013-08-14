package com.phanative.startup.scenario

trait Scenario {

  def initialize()

  def index() : Int

  def name() : String

}