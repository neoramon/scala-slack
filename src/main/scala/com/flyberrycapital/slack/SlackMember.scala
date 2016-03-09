/*
 * Copyright (c) 2014 Flyberry Capital, LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.flyberrycapital.slack

import play.api.libs.json.{JsValue, Json}


/**
  * Class for representing a Slack member
  */
case class SlackMember(
    id: String,
    name: String,
    deleted: Boolean,
    color: Option[String],
    profile: Map[String, JsValue],
    isAdmin: Option[Boolean],
    isOwner: Option[Boolean],
    has2Fa: Option[Boolean],
    hasFiles: Option[Boolean]
)

object SlackMember {
  case class SlackMemberRaw(
      id: String,
      name: String,
      deleted: Boolean,
      color: Option[String],
      profile: Map[String, JsValue],
      is_admin: Option[Boolean],
      is_owner: Option[Boolean],
      has_2fa: Option[Boolean],
      has_files: Option[Boolean]
  ) {
    def get: SlackMember = SlackMember(id, name, deleted, color, profile, is_admin, is_owner, has_2fa, has_files)
  }

  object SlackMemberRaw {
    implicit val jsonFormat = Json.format[SlackMemberRaw]
  }
}